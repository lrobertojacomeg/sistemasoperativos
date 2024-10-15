/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BolasFlotantes extends JPanel implements Runnable {
    private Bola[] bolas;

    public BolasFlotantes(int numBolas) {
        bolas = new Bola[numBolas];
        Random rand = new Random();
        for (int i = 0; i < numBolas; i++) {
            int size = rand.nextInt(50) + 20; // Tamaño de la bola
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Color aleatorio
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            bolas[i] = new Bola(x, y, size, color);
        }
        new Thread(this).start(); // Iniciar el hilo para animación
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Bola bola : bolas) {
            bola.dibujar(g);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (Bola bola : bolas) {
                bola.mover(getWidth(), getHeight());
            }
            repaint(); // Redibujar el panel
            try {
                Thread.sleep(20); // Controlar la velocidad de la animación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bolas Flotantes");
        BolasFlotantes panel = new BolasFlotantes(1000); // 10 bolas
        frame.add(panel);
        frame.setSize(500, 500); // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

