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
    
    
    public void ejecutar_p(Proceso p1, Thread t1,long tiempo){
        
        int i;
        int v =p1.getCantidad_instrucciones();
        for (i=0;i<v;i++){
            if ("ES".equals(this.p1.getBound())){
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
                p1.setEstado("Ejecutando");
               /* try {
                    //aqui el hilo espera el tiempo del ciclo
                   // t1.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }*/
                System.out.println(p1.getCantidad_instrucciones());
                
            }
        }
        p1.setEstado("Terminado");
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public Proceso getP1() {
        return p1;
    }

    public void setP1(Proceso p1) {
        this.p1 = p1;
    }
    
}
