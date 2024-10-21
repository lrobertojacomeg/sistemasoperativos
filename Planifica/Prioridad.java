/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prioridad {
    private ArrayList<ProcesoPrioridad> listaProcesos;

    public Prioridad(ArrayList<ProcesoPrioridad> procesos) {
        this.listaProcesos = procesos;
        // Ordenamos primero por prioridad, luego por tiempo de llegada en caso de empate
        Collections.sort(listaProcesos, Comparator.comparingInt(ProcesoPrioridad::getPrioridad)
                .thenComparingInt(Proceso::getTiempoLlegada));
    }

    public void ejecutar() {
        int tiempoActual = 0;
        for (ProcesoPrioridad proceso : listaProcesos) {
            if (tiempoActual < proceso.getTiempoLlegada()) {
                tiempoActual = proceso.getTiempoLlegada();
            }
            System.out.println("El proceso " + proceso.getId() + " con prioridad " + proceso.getPrioridad() + " se ejecuta en el tiempo " + tiempoActual);
            tiempoActual += proceso.getDuracion();
        }
    }
}

// Clase específica para un proceso con prioridad
class ProcesoPrioridad extends Proceso {
    private int prioridad;

    public ProcesoPrioridad(String id, int tiempoLlegada, int duracion, int prioridad) {
        super(id, tiempoLlegada, duracion);
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
