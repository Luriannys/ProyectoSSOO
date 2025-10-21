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
    
    
    
    
    public void ejecutar_p(Proceso p1, Thread t1,long tiempo,Cola bloq){
        
        int i;
        int v =p1.getCantidad_instrucciones();
        int e = p1.getCicloex();
        
        for (i=0;i<e;i++){
            if ("I/O Bound".equals(p1.getBound())){
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                //aqui el hilo espera el tiempo del ciclo
                 try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                if (p1.getCicloex()==i){
                    p1.setEstado("Bloqueado");
                    bloq.add(p1);
                    System.out.println("Bloqueado");
                    //se mueve a cola de bloqueado
                    int u;
                    for (u=0;u<p1.getCicloex()+p1.getCiclofinex();u++){
                         try {
                    //aqui el hilo espera el tiempo del ciclo
                     t1.sleep(tiempo*100);
                        } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                        //hilo espero el tiempo del ciclo
                    }
                    p1.setEstado("Ejecutando");
                    System.out.println(p1.getCantidad_instrucciones());
                    
                }
            }else{
                for (i=0;i<v;i++){
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                p1.setEstado("Ejecutando");
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                System.out.println(p1.getCantidad_instrucciones());
                }
            }
        }
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }


    
}
