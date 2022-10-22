package org.example.dcx.ufpb.br;

import javax.swing.JFrame;

public interface SistemaEleitoralInterface {

    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException;
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException;
    public int contarVotosParaCandidato(int numero);
    public boolean cadastraCandidato(String nome, int numero, Partido partido);
    public boolean cadastraEleitor(String nome, String titulo);


    public class frameInterface {
        public static void main(String[] args) {

            JFrame janela = new JFrame("Hello World");

            janela.setSize(300, 300);

            janela.setVisible(true);

        }
    }
}

