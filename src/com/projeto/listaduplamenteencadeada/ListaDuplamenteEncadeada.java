package com.projeto.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista; //Usado para incrementar e decrementar o tamanho da lista nos metodos add() e remove().

    public ListaDuplamenteEncadeada(){
        primeiroNo = null;
        ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){

        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento); //Instancia o novoNo com "Elemento" sendo o conteúdo da lista
        novoNo.setNoProximo(null); //Coloca a referencia de proximo No para o novoNo apontando para Null
        novoNo.setNoPrevio(ultimoNo); //Referencia o ultimoNo para o novoNo
        if(primeiroNo == null){
            primeiroNo = novoNo; //Se n existir primeiro item na lista, seta o novoNo como primeiro
        }
        if(ultimoNo != null){
            ultimoNo.setNoProximo(novoNo); //Referencia o ultimoNo para o novoNo(Que passa a ser o ultimo)
        }
        ultimoNo = novoNo; //Por fim, o ultimoNo para ser o novoNo
        tamanhoLista++; //Aumenta o size da lista.
    }

    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index); //Cria um noAuxiliar recebendo a referencia de index
        NoDuplo<T> novoNo = new NoDuplo<>(elemento); //Cria um novoNo recebendo o elemento(Conteudo)
        novoNo.setNoProximo(noAuxiliar); // index(noAuxiliar) passa a ser o proximo do novoNo

        if(novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio()); //se getNoProximo != null referencia o valor anterior ao index(noAuxiliar) para o novoNo
            novoNo.getNoProximo().setNoPrevio(novoNo); // Referencia o No da frente com o novoNo colocando o novoNo como anterior
        }else{
            novoNo.setNoPrevio(ultimoNo); //ultimoNo passa para tras e novoNo passa a tomar a posição de ultimoNo(Proxima linha)
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo;
        }else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
    }

    public void remove(int index){

        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo(); //Primeiro no passa a ser o proximo na lista(Garbage colector fazendo)

            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index); //getNo percorre todos os Nos da lista para retornar o index
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo()); // Pega a referencia anterior do index e linka com o proximo do index

            if(noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio()); //Pega a referencia posterior do index e linka com o anterior do index.
            }else{
                ultimoNo = noAuxiliar; //Seta o index como ultimo no
            }
        }

        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo; //Cria um noAuxiliar atribuindo o valor de primeiroNo

        for(int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo(); //Percorre a lista até chegar no index desejado.
        }

        return noAuxiliar;
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString(){
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;

        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo = " + noAuxiliar.getConteudo() + "}] ---> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += "null";

        return strRetorno;
    }
}
