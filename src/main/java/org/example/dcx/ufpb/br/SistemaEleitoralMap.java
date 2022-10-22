package org.example.dcx.ufpb.br;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SistemaEleitoralMap implements SistemaEleitoralInterface {

    private Map<String, Eleitor> eleitores;
    private Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException {
        Eleitor eleitor = this.eleitores.get(numTitulo);
        Voto voto = new Voto(numeroVotado);
        if (eleitor == null) {
            throw new TituloInexistenteException("Este titulo não existe, verifique a validade para: " + numTitulo);
        } else {
            votos.add(voto);
        }
    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidato == null) {
            throw new CandidatoInexistenteException("Não existe candidato com o nome " + nome);
        } else {
            return candidato;
        }
    }
    public int contarVotosParaCandidato(int numero){
        int cont = 0;
        for (Voto v: votos) {
            if (v.getNumeroVotado() == numero){
                cont++;
            }
        }
        return cont;
    }

    public boolean cadastraCandidato(String nome, int numero, Partido partido){
        if (!candidatos.containsKey(nome)){
            Candidato candidato = new Candidato(nome, numero, partido);
            candidatos.put(nome, candidato);
            return true;
        }
        return false;
    }


    public boolean cadastraEleitor(String nome, String titulo){
        if (!eleitores.containsKey(titulo)){
            Eleitor eleitor = new Eleitor(nome, titulo);
            eleitores.put(titulo, eleitor);
            return true;
        }
        return false;
    }

}
