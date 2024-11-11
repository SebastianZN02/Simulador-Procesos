package logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jeank
 */
public class Proceso {

    private int nombre;
    private int tiempoRafaga;
    private int tiempoLlegada;
    private int tiempoRestante;
    private int tiempoInicio;
    private int tiempoFinalizacion;
    private int prioridad;

    public Proceso(int nombre, int tiempoLlegada, int tiempoRafaga) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoRafaga = tiempoRafaga;
        this.tiempoRestante = tiempoRafaga;
        this.tiempoRestante=tiempoRafaga;
        
    }

    public Proceso(int nombre, int tiempoLlegada, int tiempoRafaga,int prioridad) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridad = prioridad;
        this.tiempoRafaga = tiempoRafaga;
        this.tiempoRestante = tiempoRafaga;
        
    }

    public int getNombre() {
        return nombre;
    }

    public int getTiempoRafaga() {
        return tiempoRafaga;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Proceso{" + "nombre=" + nombre + ", tiempoRafaga=" + tiempoRafaga + ", tiempoLlegada=" + tiempoLlegada + ", prioridad=" + prioridad + '}';
    }

    
    
}
