/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hilos;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Bola {
    private int x, y, dx, dy, size;
    private Color color;

    public Bola(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        Random rand = new Random();
        this.dx = rand.nextInt(5) + 1; // Movimiento en X
        this.dy = rand.nextInt(5) + 1; // Movimiento en Y
    }

    public void mover(int width, int height) {
        x += dx;
        y += dy;

        // Rebotar en los bordes
        if (x < 0 || x + size > width) {
            dx = -dx;
        }
        if (y < 0 || y + size > height) {
            dy = -dy;
        }
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}

