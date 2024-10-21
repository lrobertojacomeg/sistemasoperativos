/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    private Queue<Proceso> colaProcesos;
    private int quantum;  // Tiempo máximo que un proceso puede ejecutar antes de ser intercambiado

    public RoundRobin(ArrayList<Proceso> procesos, int quantum) {
        this.colaProcesos = new LinkedList<>(procesos);
        this.quantum = quantum;
    }

    public void ejecutar() {
        int tiempoActual = 0;

        while (!colaProcesos.isEmpty()) {
            Proceso proceso = colaProcesos.poll();

            if (tiempoActual < proceso.getTiempoLlegada()) {
                tiempoActual = proceso.getTiempoLlegada();
            }

            int tiempoEjecucion = Math.min(proceso.getTiempoRestante(), quantum);
            System.out.println("El proceso " + proceso.getId() + " se ejecuta en el tiempo " + tiempoActual + " por " + tiempoEjecucion + " unidades de tiempo.");

            proceso.setTiempoRestante(proceso.getTiempoRestante() - tiempoEjecucion);
            tiempoActual += tiempoEjecucion;

            // Si el proceso aún tiene tiempo restante, vuelve a la cola
            if (proceso.getTiempoRestante() > 0) {
                colaProcesos.offer(proceso);
            }
        }
    }
}

