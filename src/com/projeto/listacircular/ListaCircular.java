package com.projeto.listacircular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;

    private int tamanhoLista;

    public ListaCircular(No<T> cabeca, No<T> cauda) {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false; //Retorna se a lista esta vazia
    }

    public int size(){
        return this.tamanhoLista;
    }
}
