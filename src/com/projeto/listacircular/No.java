package com.projeto.listacircular;

public class No<T> {

    private T conteudo; //Onde fica armazenado o valor da lista
    private No<T> noProximo; //Responsavel por encadear os Nos

    public No(T conteudo, No<T> noProximo) {
        this.conteudo = conteudo;
        this.noProximo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(No<T> noProximo) {
        this.noProximo = noProximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}