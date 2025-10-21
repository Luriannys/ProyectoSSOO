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
   
    Cola listo= new Cola("Listo");//organizar la lista dependiendo del plan 
    //Plan plan;
    Cola bloq= new Cola("Bloqueado");
    Cola terminado= new Cola("Terminado");
    
   /* public void ejec_plan(Plan plan){
        this.plan.selec_plan();
    }*/
    
   

    public void iniciar(long tiempo) {
        
        Thread t1 = new Thread();
        
        t1.start();
        PC pc = new PC();
        Proceso p1 = new Proceso("a",21,"CPU",0,0);
        listo.add_listo(p1);
        Proceso p2 = new Proceso("b",21,"I/O Bound",5,3);
        listo.add_listo(p2);
        Proceso p3 = new Proceso("c",21,"CPU",0,0);
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
    }
    public void agregar_proceso_cpu(CPU cpu, Cola listo,long tiempo, Thread t1,Cola bloq){
        //agarra el primero de la cola de listos lo desencola y al cpu para ejecitar
        Proceso p1 = listo.getCabeza().getProceso();
        listo.desencolar();
        
        cpu.ejecutar_p(p1,t1,tiempo,bloq);
        
}
    public void terminar_proceso(Proceso p1, Cola term){
            p1.setEstado("Terminado");
            term.add(p1);

    }
}
