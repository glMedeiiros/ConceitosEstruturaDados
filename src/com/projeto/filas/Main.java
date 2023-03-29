package com.projeto.filas;

public class Main {
    public static void main(String[] args) {

        Fila minhaFila = new Fila();

        minhaFila.enqueue("Primeiro");
        minhaFila.enqueue(2);
        minhaFila.enqueue('T');


        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila);

        System.out.println(minhaFila.first());

        System.out.println(minhaFila);

        minhaFila.enqueue("teste2");

        System.out.println(minhaFila);
    }
}
