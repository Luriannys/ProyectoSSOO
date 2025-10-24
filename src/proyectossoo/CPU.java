
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class CPU implements Runnable {
    
    /*WEY QUE VA A MANEJAR TODO XD 
    */
    //proceso en ejecucion
    
    long tiempo;
    Scheduler sch ;
    Semaforo sf=new Semaforo();
    
    @Override
    public void run(){
        this.iniciar(tiempo);
        
         
    }
    
    
    public void iniciar(long tiempo) {
        
        
        
        
        Proceso p1 = new Proceso("a",10,"CPU",5,4);
        sch.getPlan().add(p1);
        Proceso p2 = new Proceso("b",13,"I/O Bound",0,0);
        sch.getPlan().add(p2);
        Proceso p3 = new Proceso("c",5,"CPU",4,3);
        sch.getPlan().add(p3);
        sch.politica_planificacion("FIFO");
//        PC pc = new PC(listo);
//        pc.siguiente_proceso(listo);

       
      while(true){  
        while (!sch.listo.estaVacia()){
             
            this.ejecutar_p( sch.bloq, sch.listo);
            
             
        }
        if (sch.listo.estaVacia()){
            System.out.println("WEY SE ACABARON LOS PROCESOS");
            }   
        
        
        
        
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
        int e = p1.getCiclofinex();
        p1.setEstado("Ejecutando");
        //poner el ciclo de excepcion 
        System.out.println("Procesando "+ p1.getNombre());
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
                    
                    sch.bloquear_proceso(p1);
                    p1.setEstado("Bloqueado");
                    
                   
                   
                    //se mueve a cola de bloqueado
                   //metodo del scheduler que movera el proceso a bloqueado
                    
                    
                                       
                }else{
            System.out.println("Ejecutando");
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
        }}
    
    

    public Scheduler getSch() {
        return sch;
    }

    public void setSch(Scheduler sch) {
        this.sch = sch;
    }

    public CPU(long tiempo,Scheduler sch) {
        this.tiempo = tiempo;
        this.sch=sch;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public Semaforo getSf() {
        return sf;
    }

    public void setSf(Semaforo sf) {
        this.sf = sf;
    }

    
    
   


    
}


    
    
   


   

