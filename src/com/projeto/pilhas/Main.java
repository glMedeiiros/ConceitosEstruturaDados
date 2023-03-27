package com.projeto.pilhas;

public class Main {

    //Pilhas utilizam o metodo TOP para observar o primeiro/topo item da Pilha
    //Pilhas utilizam o metodo POP para recuperar o primeiro/topo item da Pilha(E excluido da pilha)
    //Pilhas utilizam o metodo PUSH para inserir um item no topo da pilha
    //LIFO(Last in First out)

    public static void main(String[] args) {

        Pilha minhaPilha = new Pilha();

        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        System.out.println(minhaPilha);
    }
}
