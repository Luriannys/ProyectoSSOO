
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class CPU {
    /*WEY QUE VA A MANEJAR TODO XD 
    */
    //proceso en ejecucion
    Scheduler sch = new Scheduler();
    long tiempo;
    
    public void iniciar(long tiempo) {
        
        
        Thread t1 = new Thread();
        
        t1.start();
        
        Proceso p1 = new Proceso("a",10,"CPU",0,0);
        sch.listo.add_listo(p1);
        Proceso p2 = new Proceso("b",20,"I/O Bound",10,3);
        sch.listo.add_listo(p2);
        Proceso p3 = new Proceso("c",3,"CPU",0,0);
        sch.listo.add_listo(p3);
        
//        PC pc = new PC(listo);
//        pc.siguiente_proceso(listo);
       
        
        while (!sch.listo.estaVacia()){
            sch.agregar_proceso_cpu(this, sch.listo, sch.bloq);
            sch.terminar_proceso(p1,sch.terminado);
            
        }
      
        
        
        
    
    }
    
    public void ejecutar_p(Proceso p1,Cola bloq, Cola listo){
        this.iniciar(tiempo);
        Thread t1 = new Thread();
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

    public Scheduler getSch() {
        return sch;
    }

    public void setSch(Scheduler sch) {
        this.sch = sch;
    }

    public CPU(long tiempo) {
        this.tiempo = tiempo;
    }

    
    
   


    
}
