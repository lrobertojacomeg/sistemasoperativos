/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hilos;

class MyRunnable implements Runnable {
    private String nombre;

    public MyRunnable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(nombre + ": ");
            for (int j = 0; j < i; j++) {
                System.out.print("• "); // Dibujar una bolita por iteración
            }
            System.out.println(); // Nueva línea después de las bolitas
            try {
                Thread.sleep(1000); // Pausar el hilo durante 1 segundo
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(nombre + " ha terminado.");
    }

    public static void main(String[] args) {
        Thread hilo1 = new Thread(new MyRunnable("Hilo 1"));
        Thread hilo2 = new Thread(new MyRunnable("Hilo 2"));
        Thread hilo3 = new Thread(new MyRunnable("Hilo 3"));
        Thread hilo4 = new Thread(new MyRunnable("Hilo 4"));

        hilo1.start(); // Iniciar el hilo 1
        hilo2.start(); // Iniciar el hilo 2
        hilo3.start(); // Iniciar el hilo 3
        hilo4.start(); // Iniciar el hilo 4
    }
}

