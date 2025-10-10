/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Scheduler {
   /* GUARDA EL PLANIFICADOR ACTUAL 
    FCFS (Primero que entra sale)
    round robin
    SPN
    SRt
    HRRN
    Feedback
    */
    PC pc;
    Cola listo;//organizar la lista dependiendo del plan 
    Plan plan;
    
    public void ejec_plan(Plan plan){
        this.plan.selec_plan();
    }
    
    
}
