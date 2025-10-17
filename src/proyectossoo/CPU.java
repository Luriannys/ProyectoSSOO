/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class CPU {
    /*WEY QUE VA A MANEJAR TODO XD 
    */
    //proceso en ejecucion
    PC pc;
    Proceso p1;
    
    
    public void ejecutar_p(Proceso p1){
        int i;
        for (i=0;i<this.p1.getCantidad_instrucciones();i++){
            if ("ESBound".equals(this.p1.getBound())){
                this.p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                //aqui el hilo espera el tiempo del ciclo
                if (this.p1.getCicloex()==i){
                    p1.setEstado("Bloqueado");
                    //se mueve a cola de bloqueado
                    int u;
                    for (u=0;u<p1.getCiclofinex()+p1.getCiclofinex();u++){
                        //hilo espero el tiempo del ciclo
                    }
                    p1.setEstado("Ejecutando");
                    
                    
                }
            }else{
                this.p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                //aqui el hilo espera el tiempo del ciclo
            }
        }
    }
}
