package com.projeto.listaduplamenteencadeada;

public class Main {

    public static void main(String[] args){

        ListaDuplamenteEncadeada<String> minhalista = new ListaDuplamenteEncadeada<>();

        minhalista.add("Teste1");
        minhalista.add("Teste2");
        minhalista.add("Teste3");
        minhalista.add("Teste4");
        minhalista.add("Teste5");

        System.out.println(minhalista);

        minhalista.add(3, "Valor Trocado");

        System.out.println(minhalista);

        minhalista.remove(4);

        System.out.println(minhalista);

        System.out.println(minhalista.get(0));
        System.out.println(minhalista.get(1));
        System.out.println(minhalista.get(2));
        System.out.println(minhalista.get(3));
        System.out.println(minhalista.get(4));
    }

}
