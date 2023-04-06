package com.projeto.listacircular;

public class Main {
    public static void main(String[] args){

        ListaCircular<String> minhalista = new ListaCircular<>();

        minhalista.add("Teste1");
        minhalista.add("Teste2");
        minhalista.add("Teste3");
        minhalista.add("Teste4");

        System.out.println(minhalista);

        minhalista.remove(2);

        System.out.println(minhalista);

        System.out.println(minhalista.get(6));
        System.out.println(minhalista.get(2));
    }
}
