package com.projeto.pilhas;

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


    @Override
    public String toString() {
        String stringRetorno = "---------------\n"; //Concatena com os valores abaixo
        stringRetorno += "    Pilha\n";
        stringRetorno += "---------------\n";

        No noAuxiliar = refNoEntradaPilha; //Pega referencia do valor no topo da pilha

        while(true){
            if (noAuxiliar != null){ //
                stringRetorno += "[No{dado= " + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }
        }
        stringRetorno += "===============";

        return stringRetorno;
    }
}
