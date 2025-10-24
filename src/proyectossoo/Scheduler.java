/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

import java.util.HashSet;

/**
 *
 * @author rgabr
 */
public class Scheduler extends Thread {
   /* GUARDA EL PLANIFICADOR ACTUAL 
    FCFS (Primero que entra sale)
    round robin
    SPN
    SRt
    HRRN
    Feedback
    */
    int memoria; 
    Cola listo= new Cola("Listo");
    Cola bloqueado= new Cola("Bloqueado");
    Cola terminado= new Cola("Terminado");
    Cola listoSuspendido = new Cola("Listo suspendido");
    Cola bloqSuspendido = new Cola("Bloqueado suspendido");
    Cola plan = new Cola("Plan");
    
    // Agregar proceso a cola Listo
    public void agregar_listo(Proceso newProceso){
        listo.add(newProceso);
        newProceso.setEstado("Listo");
    }
    
    // Terminar proceso y agregar a cola Terminados
    public void terminar_proceso(Proceso p){
        p.setEstado("Terminado");
        terminado.add(p);
    }
    
    //Bloquear proceso
    public void bloquear_proceso(Proceso p){
        p.setEstado("Bloqueado");
        bloqueado.add(p);
    }

    public void politica_planificacion(String s){
        if (s.equals("FCFS")){
            
        }
    }
    
    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public Cola getListo() {
        return listo;
    }

    public void setListo(Cola listo) {
        this.listo = listo;
    }

    public Cola getPlan() {
        return plan;
    }

    public void setPlan(Cola plan) {
        this.plan = plan;
    }

    public Cola getBloq() {
        return bloq;
    }

    public void setBloq(Cola bloq) {
        this.bloq = bloq;
    }

    public Cola getTerminado() {
        return terminado;
    }

    public void setTerminado(Cola terminado) {
        this.terminado = terminado;
    }

    public Cola getListoSuspendido() {
        return listoSuspendido;
    }

    public void setListoSuspendido(Cola listoSuspendido) {
        this.listoSuspendido = listoSuspendido;
    }

    public Cola getBloqSuspendido() {
        return bloqSuspendido;
    }

    public void setBloqSuspendido(Cola bloqSuspendido) {
        this.bloqSuspendido = bloqSuspendido;
    }

}
