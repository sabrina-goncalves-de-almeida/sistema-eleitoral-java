package org.example.dcx.ufpb.br;

public class Voto {
    private int numeroVotado;

    public Voto(int numeroVotado){
        this.numeroVotado = numeroVotado;
    }

    public int getNumeroVotado(){
        return this.numeroVotado;
    }

    public void setNumeroVotado(int numeroVotado){
        this.numeroVotado = numeroVotado;
    }
}
