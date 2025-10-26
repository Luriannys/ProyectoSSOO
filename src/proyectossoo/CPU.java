package proyectossoo;

import java.time.Duration;

/**
 *
 * @author rgabr
 */
public class CPU implements Runnable {

    /*WEY QUE VA A MANEJAR TODO XD 
     */
    //proceso en ejecucion
    Scheduler sch = new Scheduler();
    long tiempo = sch.getTiempo();
    Pila logList = new Pila();
    Semaforo sf;
    Nodo n =new Nodo();
    @Override
    public void run() {
        this.iniciar(tiempo);
        
    }
    
    public void iniciar(long tiempo) {
        
        Proceso p1 = new Proceso("a", 10, "CPU", 6, 4,1);
        sch.agregar_listo(p1);
        Proceso p2 = new Proceso("b", 13, "I/O Bound", 0, 0,1);
        sch.agregar_listo(p2);
        Proceso p3 = new Proceso("c", 5, "CPU", 4, 3);
        sch.agregar_listo(p3);
        Proceso p4 = new Proceso("d", 90, "CPU", 0, 0);
        sch.agregar_listo(p4);
        
//        PC pc = new PC(listo);
//        pc.siguiente_proceso(listo);

        while (true) {     
            sch.politica_planificacion("Round Robin");
            while (!sch.listo.estaVacia()) {
                
                if(sch.getCiclosRR()!=0){
                    this.ejecutar_RR(sch.bloq, sch.listo);
                }else{
                    this.ejecutar_p(sch.bloq, sch.listo);
                }                        
            }
            if (sch.listo.estaVacia()) {
                //System.out.println("WEY SE ACABARON LOS PROCESOS");
                
            }            
            
        }
    }
    
    public void ejecutar_RR(Cola bloq, Cola listo) {
        int u= this.sch.getCiclosRR();
            
        Proceso p1 = sch.getListo().getCabeza().getProceso();
        n.setProceso(p1);
        //Proceso p2=this.getListo().getCabeza().getSiguiente().getProceso();
        listo.desencolar();
        
        Thread t1 = new Thread();
        t1.start();
        int i;
        int v = p1.getCantidad_instrucciones();
        int e = p1.getCiclofinex();
        p1.setEstado("Ejecutando");
        //poner el ciclo de excepcion 
        System.out.println("Procesando " + p1.getNombre());
        if (e > 0) {
            
            for (i = 0; i < e; i++) {
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                
                System.out.println(p1.getCantidad_instrucciones());
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                u--;
                if (u==0&& p1.getCantidad_instrucciones()>0){
                    sch.setMemoria(sch.getMemoria()+p1.getCantidad_instrucciones_iniciales());
                    sch.agregar_listo(p1);
                    System.out.println("Se te acabo el tiempo perro");
                    break;
                }
            }
            System.out.println("Bloqueado");
            
                    sch.bloquear_proceso(p1);
                    
            

            //se mueve a cola de bloqueado
            //metodo del scheduler que movera el proceso a bloqueado
        } else {
            System.out.println("Ejecutando");
            p1.setEstado("Ejecutando");
            for (i = 0; i < v; i++) {
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                
                
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                System.out.println(p1.getCantidad_instrucciones());
                u--;
                if (u==0 && p1.getCantidad_instrucciones()>0){
                    sch.setMemoria(sch.getMemoria()+p1.getCantidad_instrucciones_iniciales());
                    sch.agregar_listo(p1);
                    System.out.println("Se te acabo el tiempo perro");
                    
                    break;
                }
            }
            if(p1.getCantidad_instrucciones()==0){
                sch.terminar_proceso(p1);
            System.out.println("Proceso Terminado");
            }
            
        }
            
            
        }
    
    public void ejecutar_p(Cola bloq, Cola listo) {
        
        Proceso p1 = sch.getListo().getCabeza().getProceso();
        //Proceso p2=this.getListo().getCabeza().getSiguiente().getProceso();
        listo.desencolar();
        
        Thread t1 = new Thread();
        t1.start();
        int i;
        int v = p1.getCantidad_instrucciones();
        int e = p1.getCiclofinex();
        p1.setEstado("Ejecutando");
        //poner el ciclo de excepcion 
        System.out.println("Procesando " + p1.getNombre());
        if (e > 0) {
            
            for (i = 0; i < e; i++) {
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                
                System.out.println(p1.getCantidad_instrucciones());
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
            System.out.println("Bloqueado");
            
            sch.bloquear_proceso(p1);
           

            //se mueve a cola de bloqueado
            //metodo del scheduler que movera el proceso a bloqueado
        } else {
            System.out.println("Ejecutando");
            for (i = 0; i < v; i++) {
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                p1.setEstado("Ejecutando");
                
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
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
    
    public Pila getLogList() {
        return logList;
    }
    
    public void setLogList(Pila logList) {
        this.logList = logList;
    }

    public Nodo getN() {
        return n;
    }

    public void setN(Nodo n) {
        this.n = n;
    }
    
}
