
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class CPU implements Runnable {
    
    /*WEY QUE VA A MANEJAR TODO XD 
    */
    //proceso en ejecucion
    Scheduler sch = new Scheduler();
    long tiempo;
    
    @Override
    public void run(){
        
        
        this.iniciar(tiempo);
        
         
    }
    
    
    public void iniciar(long tiempo) {
        
        
        
        
        Proceso p1 = new Proceso("a",10,"CPU",0,0);
        sch.agregar_listo(p1);
        Proceso p2 = new Proceso("b",13,"I/O Bound",10,3);
        sch.agregar_listo(p2);
        Proceso p3 = new Proceso("c",5,"CPU",0,0);
        sch.agregar_listo(p3);
        
//        PC pc = new PC(listo);
//        pc.siguiente_proceso(listo);
       
        
        while (!sch.listo.estaVacia()){
             
            this.ejecutar_p( sch.bloq, sch.listo);
            
             
        }
        if (sch.listo.estaVacia()){
            System.out.println("WEY SE ACABARON LOS PROCESOS");
            
}
      
        
        
        
    
    }
     
        

    
    public void ejecutar_p(Cola bloq, Cola listo){
       
            Proceso p1 = sch.getListo().getCabeza().getProceso();
        //Proceso p2=this.getListo().getCabeza().getSiguiente().getProceso();
        listo.desencolar();
        
        Thread t1 = new Thread();
        t1.start();
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
                    Thread t2 = new Thread();
                    t2.start();
                    p1.setEstado("Bloqueado");
                    bloq.add(p1);
                   
                    //se mueve a cola de bloqueado
                   //metodo del scheduler que movera el proceso a bloqueado
                    
                    
                                       
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
                 sch.terminar_proceso(p1);
                    System.out.println("Proceso Terminado");
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


    
    
   


   

