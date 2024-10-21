/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FCFS {
    private ArrayList<Proceso> listaProcesos;

    public FCFS(ArrayList<Proceso> procesos) {
        this.listaProcesos = procesos;
        Collections.sort(listaProcesos, Comparator.comparingInt(Proceso::getTiempoLlegada));  // Ordena por tiempo de llegada
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

