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
 
 
    
    
    
    public void ejecutar_p(Proceso p1, Thread t1,long tiempo,Cola bloq, Cola listo){
        
        int i;
        int v =p1.getCantidad_instrucciones();
        int e = p1.getCicloex();
        p1.setEstado("Ejecutando");
        //poner el ciclo de excepcion 
        if (e>0){
            for (i=0;i<e;i++){
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                
                System.out.println(p1.getCantidad_instrucciones());
                 try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
                    System.out.println("Bloqueado");
                    p1.setEstado("Bloqueado");
                    bloq.add(p1);
                    
                    //se mueve a cola de bloqueado
                    int u;
                    for (u=0;u<p1.getCiclofinex();u++){
                        System.out.println("Bloqueado"+u);
                         try {
                    //aqui el hilo espera el tiempo del ciclo
                     t1.sleep(tiempo*100);
                        } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                        
                        
                    }
                    bloq.desencolar();
                    p1.setEstado("Ejecutando");
                    for (i=e;i<v;i++){
                        p1.setCantidad_instrucciones(p1.getCantidad_instrucciones()-1);
                        System.out.println(p1.getCantidad_instrucciones()); 
                          System.out.println("Bloqueado"+u);
                         try {
                    //aqui el hilo espera el tiempo del ciclo
                     t1.sleep(tiempo*100);
                        } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
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
