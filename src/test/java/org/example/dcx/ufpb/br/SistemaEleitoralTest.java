package org.example.dcx.ufpb.br;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaEleitoralTest {
    SistemaEleitoralMap sistema = new SistemaEleitoralMap();

    @Test
    public void testaCadastraEleitor(){
        sistema.cadastraEleitor("Ana", "111.222.333-45");
        assertEquals(false, sistema.cadastraEleitor("Ana", "111.222.333-45"));
    }

    @Test
    public void testaCadastraCandidato(){
        assertTrue(sistema.cadastraCandidato("Maria",333,Partido.PARTIDO2));
        assertEquals(false, sistema.cadastraCandidato("Maria",333,Partido.PARTIDO2));
    }

    @Test
    public void testaVotar(){
        sistema.cadastraEleitor("Ana", "111.222.333-45");
        sistema.cadastraCandidato("Maria",333,Partido.PARTIDO2);

        try{
            sistema.votar("111.222.333-45",333);
        }catch (TituloInexistenteException e){
            System.out.println(e.getMessage());
        }

        try {
            sistema.obterDadosDoCandidato("Maria");
        }catch (CandidatoInexistenteException e){
            System.out.println(e.getMessage());
        }

        try {
            sistema.obterDadosDoCandidato("Ana");
        }catch (CandidatoInexistenteException e){
            System.out.println(e.getMessage());
        }

        try{
            sistema.votar("111.222",333);
        }catch (TituloInexistenteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testaContadorDeVotos() throws TituloInexistenteException {
        sistema.cadastraEleitor("Ana", "111.222.333-45");
        sistema.cadastraCandidato("Maria",333,Partido.PARTIDO2);
        try{
            sistema.votar("111.222.333-45", 333);
        }catch (TituloInexistenteException e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
        System.out.println(sistema.contarVotosParaCandidato(333));
        assertEquals(0, sistema.contarVotosParaCandidato(444));
    }
}
