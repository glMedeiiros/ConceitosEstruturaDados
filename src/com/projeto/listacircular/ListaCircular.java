package com.projeto.listacircular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;

    private int tamanhoLista;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    public void add(T elemento){
        No<T> novoNo = new No<>(elemento);

        if(this.tamanhoLista == 0){ //Caso Primeiro da Lista, set novoNo como ambos cabeca e cauda;
            this.cabeca = novoNo;
            this.cauda = cabeca;
        }else{// Caso outro index colocar novoNo como ultimo(Atras da antiga cauda) e referenciar para a cabeça.
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){

        if(index >= this.tamanhoLista){
            throw new IndexOutOfBoundsException("O indice e maior que o tamanho da lista");
        }

        No<T> noAuxiliar = this.cauda;

        if(index == 0){
            this.cauda = cauda.getNoProximo();
            this.cabeca.setNoProximo(cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }

            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo()); // EX: 2(ref) aponta para 4(ref) assim perdendo a referencia para 3
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo(); //Retorna o conteudo do No.
    }

    private No<T> getNo(int index){

        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia"); //Exceção

        if(index == 0){
            return this.cauda; //Primeiro item
        }

        No<T> noAuxiliar = cauda;

        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo(); //Percorre o No até o index;
        }
        return noAuxiliar;
    }

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false; //Retorna se a lista esta vazia
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "{No[" + noAuxiliar.getConteudo() + "]} ---->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += isEmpty() ? 0 : this.cauda.getConteudo() + "...";


        return strRetorno;
    }
}
