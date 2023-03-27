package com.projeto.filas;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha; //Guarda a antiga referencia e dado
        refNoEntradaPilha = novoNo; //Recebe novo dado e referencia
        refNoEntradaPilha.setRefNo(refAuxiliar); //Insere o dado e referencia na base do No

    }

    public No pop(){
        if(!this.isEmpty()){
            No noPoped = refNoEntradaPilha; //Guarda o valor que esta no topo da pilha
            refNoEntradaPilha = refNoEntradaPilha.getRefNo(); //Sobe o valor em Segundo para o TOPO
            return noPoped; //Retorna o valor solicitado(Que e excluir da Pilha)
        }

        return null;
    }

    //Retorna o item no topo da pilha
    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null ? true : false;
    }
}
