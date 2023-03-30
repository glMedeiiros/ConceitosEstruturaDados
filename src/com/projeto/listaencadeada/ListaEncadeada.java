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
    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }
}
