/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJF {
    private ArrayList<Proceso> listaProcesos;

    public SJF(ArrayList<Proceso> procesos) {
        this.listaProcesos = procesos;
        // Ordenamos primero por tiempo de llegada, luego por duración en caso de empate
        Collections.sort(listaProcesos, Comparator.comparingInt(Proceso::getDuracion)
                .thenComparingInt(Proceso::getTiempoLlegada));
    }

    public void ejecutar() {
        int tiempoActual = 0;
        for (Proceso proceso : listaProcesos) {
            if (tiempoActual < proceso.getTiempoLlegada()) {
                tiempoActual = proceso.getTiempoLlegada();
            }
            System.out.println("El proceso " + proceso.getId() + " se ejecuta en el tiempo " + tiempoActual);
            tiempoActual += proceso.getDuracion();
        }
    }
}

