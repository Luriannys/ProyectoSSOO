/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class PC {
    /*WEY QUE VA AN0TAR EL PROCESO EN EJECUCION Y EL SIGUIENTE */
    Proceso P_actual;
    Proceso P_siguiente;
    int contador;
    Cola listo;
    

    public PC(Cola listo) {
        
    }

    public Proceso siguiente_proceso(Cola listo){
        P_actual=listo.getCabeza().getProceso() ;
        P_siguiente=listo.getCabeza().getSiguiente().getProceso();
        contador++;
        return this.getP_actual();
        
    }
    public Proceso getP_actual() {
        return P_actual;
    }

    public void setP_actual(Proceso P_actual) {
        this.P_actual = P_actual;
    }

    public Proceso getP_siguiente() {
        return P_siguiente;
    }

    public void setP_siguiente(Proceso P_siguiente) {
        this.P_siguiente = P_siguiente;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Cola getListo() {
        return listo;
    }

    public void setListo(Cola listo) {
        this.listo = listo;
    }
    

}
