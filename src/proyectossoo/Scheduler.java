/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

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
    //PC pc;
    CPU cpu;
   PC pc;
    Cola listo= new Cola("Listo");//organizar la lista dependiendo del plan 
    //Plan plan;
    Cola bloq= new Cola("Bloqueado");
    Cola terminado= new Cola("Terminado");
    Cola listoSuspendido = new Cola("Listo suspendido");
    Cola bloqSuspendido = new Cola("Bloqueado suspendido");
    
   /* public void ejec_plan(Plan plan){
        this.plan.selec_plan();
    }*/
    
   

    public void iniciar(long tiempo) {
        
        Thread t1 = new Thread();
        
        t1.start();
        
        Proceso p1 = new Proceso("a",10,"CPU",0,0);
        listo.add_listo(p1);
        Proceso p2 = new Proceso("b",20,"I/O Bound",10,3);
        listo.add_listo(p2);
        Proceso p3 = new Proceso("c",3,"CPU",0,0);
        listo.add_listo(p3);
        CPU cpu = new CPU();
        
        int i;
        for (i=0;i<listo.getTamano();i++){
            this.agregar_proceso_cpu(cpu, listo,tiempo,t1,bloq);
            this.terminar_proceso(p1,this.terminado);
        }
        int u;
        for (u=0;u<listo.getTamano();u++){
            
        }
        this.terminado.add(p1);
        
        
    
    }
    public void agregar_proceso_cpu(CPU cpu, Cola listo,long tiempo, Thread t1,Cola bloq){
        //agarra el primero de la cola de listos lo desencola y al cpu para ejecitar
        Proceso p1 = listo.getCabeza().getProceso();
        Proceso p2 = listo.getCabeza().getSiguiente().getProceso();
        listo.desencolar();
        
        pc.setP_actual(p1);
        pc.setP_siguiente(p1);
        
        cpu.ejecutar_p(p1,t1,tiempo,bloq);
        
}
    public void terminar_proceso(Proceso p1, Cola term){
            p1.setEstado("Terminado");
            term.add(p1);

    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

//    public PC getPc() {
//        return pc;
//    }
//
//    public void setPc(PC pc) {
//        this.pc = pc;
//    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Cola getListo() {
        return listo;
    }

    public void setListo(Cola listo) {
        this.listo = listo;
    }

//    public Plan getPlan() {
//        return plan;
//    }
//
//    public void setPlan(Plan plan) {
//        this.plan = plan;
//    }

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

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }
    
    

    public Scheduler() {
        
        Cola listo= new Cola("Listo");//organizar la lista dependiendo del plan 
        Cola bloq= new Cola("Bloqueado");
        Cola terminado= new Cola("Terminado");
    
    }
    
    
    
}
