/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planifica;

public class Proceso {
    private String id;
    private int tiempoLlegada;
    private int duracion;
    private int tiempoRestante;
    
    public Proceso(String id, int tiempoLlegada, int duracion) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.tiempoRestante = duracion;
    }

    // Getters y setters para acceder a las variables
    public String getId() {
        return id;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
}
