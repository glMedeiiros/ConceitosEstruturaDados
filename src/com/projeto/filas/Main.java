package com.projeto.filas;

public class Main {
    public static void main(String[] args) {

        Fila minhaFila = new Fila();

        minhaFila.enqueue(new No("Primeiro"));
        minhaFila.enqueue(new No(2));
        minhaFila.enqueue(new No('T'));


        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila);

        System.out.println(minhaFila.first());

        System.out.println(minhaFila);

        minhaFila.enqueue(new No("teste2"));

        System.out.println(minhaFila);
    }
}
