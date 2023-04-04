package com.projeto.listaencadeada;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo); //Instancia o No com o conteudo

        if(this.isEmpty()){ //Se referenciaEntrada == Null ele adiciona como primeiro No
            referenciaEntrada = novoNo;
            return; //Usada para terminar a funcao
        }

        No<T> noAuxiliar = referenciaEntrada; // Grava o primeiro No em uma variavel auxiliar

        for(int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo(); //Percorre a Lista para ir ate o final e inserir o novoNo
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){

        return getNo(index).getConteudo();

    }
    private No<T> getNo(int index){

        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for(int i = 0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo(); //Percorre a Lista para ir ate o final e inserir o novoNo
        }
        return noRetorno;
    }

    public T remove(int index){
        No<T> noPivor = this.getNo(index);

        if(index == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);

        noAnterior.setProximoNo(noPivor.getProximoNo());

        return noPivor.getConteudo();
    }


    public int size(){
        int tamanhoLista = 0; //Define uma variavel para contar o tamanho da lista
        No<T> referenciaAux = referenciaEntrada;

        while(true){
            if(referenciaAux != null){
                tamanhoLista++; //Se referenciaEntrada diferente de Nulo +1;

                if(referenciaAux.getProximoNo() != null){ //Verifica se o proximo no/valor e diferente de NULO(Assim evita de aumentar o tamanho da lista sem ter verificacao antes
                    referenciaAux = referenciaAux.getProximoNo(); //Recebe o proximo No
                }else{
                    break; //Break Se o no for Null
                }

            }else{
                break;
            }
        }

        return tamanhoLista;
    }

    private void validaIndice(int index){
        if(index >= size()){ //Excecao caso o index seja maior que o tamanho da lista
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Nao existe conteudo no indice " + index + " desta lista. Esta lista so vai ate o indice " + ultimoIndice);
        }
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = referenciaEntrada;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}] ----->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += "null";

        return strRetorno;
    }
}
