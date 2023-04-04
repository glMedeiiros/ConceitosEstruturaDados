package com.projeto.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        primeiroNo = null;
        ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public int size(){
        return tamanhoLista;
    }
}
