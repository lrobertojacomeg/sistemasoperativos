/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso("P1", 0, 8));
        procesos.add(new Proceso("P2", 1, 4));
        procesos.add(new Proceso("P3", 2, 9));
        procesos.add(new Proceso("P4", 3, 5));

        System.out.println("Ejecución con FCFS:");
        FCFS fcfs = new FCFS(procesos);
        fcfs.ejecutar();

        System.out.println("\nEjecución con SJF:");
        SJF sjf = new SJF(procesos);
        sjf.ejecutar();

        System.out.println("\nEjecución con Round Robin (Quantum = 3):");
        RoundRobin rr = new RoundRobin(procesos, 3);
        rr.ejecutar();

        ArrayList<ProcesoPrioridad> procesosConPrioridad = new ArrayList<>();
        procesosConPrioridad.add(new ProcesoPrioridad("P1", 0, 8, 1));
        procesosConPrioridad.add(new ProcesoPrioridad("P2", 1, 4, 3));
        procesosConPrioridad.add(new ProcesoPrioridad("P3", 2, 9, 2));
        procesosConPrioridad.add(new ProcesoPrioridad("P4", 3, 5, 4));

        System.out.println("\nEjecución con Prioridad:");
        Prioridad prioridad = new Prioridad(procesosConPrioridad);
        prioridad.ejecutar();
    }
}
