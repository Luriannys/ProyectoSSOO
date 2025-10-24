
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Scheduler implements Runnable {
    
    int memoria; 
    long tiempo;
    Cola listo= new Cola("Listo");
    Cola bloq= new Cola("Bloqueado");
    Cola terminado= new Cola("Terminado");
    Cola listoSuspendido = new Cola("Listo suspendido");
    Cola bloqSuspendido = new Cola("Bloqueado suspendido");
    Cola plan = new Cola("Plan");
    Semaforo sfbloq= new Semaforo();
    Semaforo sflisto= new Semaforo();
    
    @Override
    public void run(){
        while(true){
        this.espera_bloqueados();
        }
        
    }
    
    // Agregar proceso a cola Listo
    public void agregar_listo(Proceso p){
        listo.add(p);
        p.setEstado("Listo");
    }
    
    // Terminar proceso y agregar a cola Terminados
    public void terminar_proceso(Proceso p){
        p.setEstado("Terminado");
        terminado.add(p);
    }
    
    // Bloquear proceso
    public void bloquear_proceso(Proceso p){
        p.setEstado("Bloqueado");
        bloq.add(p);
        sfbloq.esperar();
    }
    
    // Suspender proceso listo
    public void suspender_listo(Proceso p){
        p.setEstado("Listo suspendido");
        listoSuspendido.add(p);
        int nueva_memoria = memoria - p.getCantidad_instrucciones();
        if (nueva_memoria < 0){
            setMemoria(0);
        } else {
            setMemoria(nueva_memoria);
        }
    }
    
    // Suspender proceso bloqueado
    public void suspender_bloqueado(Proceso p){
        p.setEstado("Bloqueado suspendido");
        bloqSuspendido.add(p);
        int nueva_memoria = memoria - p.getCantidad_instrucciones();
        if (nueva_memoria < 0){
            setMemoria(0);
        } else {
            setMemoria(nueva_memoria);
        }
    }

    // Cambiar politica de planificacion
    public void politica_planificacion(String s){
        switch (s) {
            case "FIFO" -> {
                // LOGICA FIFO
                int i;
                int e = this.getPlan().getTamano();
                for(i=0;i<e;i++){
                    this.agregar_listo(this.getPlan().getCabeza().getProceso());
                    this.getPlan().desencolar();
                }
            }
            case "Round Robin" -> {
                // LOGICA ROUND ROBIN
            }
            case "SPN" -> {
                // LOGICA SPN
            }
            case "SRT" -> {
                // LOGICA SRT
            }
            case "HRRN" -> {
                // LOGICA HRRN
            }
            case "Realimentación" -> {
                // LOGICA REALIMENTACION
            }
            default -> {
                
            }
        }
    }
    public void espera_bloqueados(){
        Thread t2 = new Thread();
       
        if (bloq.getTamano()==0){
            
            System.out.println("no hay bloqueados");
             try {
                    //aqui el hilo espera el tiempo del ciclo
                    t2.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                  

        }else{
        t2.start();
            System.out.println("Procesando bloqueado");
        int i;
        int v=this.getBloq().getCabeza().getProceso().getCiclofinex();
        for (i=0;i<v;i++){
                this.getBloq().getCabeza().getProceso().setCiclofinex(this.getBloq().getCabeza().getProceso().getCiclofinex()-1);
                
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t2.sleep(tiempo*100);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                System.out.println("Bloqueado "+ this.getBloq().getCabeza().getProceso().getCiclofinex() );
                }
        this.agregar_listo(this.getBloq().getCabeza().getProceso());
        bloq.desencolar();
        sfbloq.adquirir();
        
        
    }
    }
    
    
    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public Cola getListo() {
        return listo;
    }

    public void setListo(Cola listo) {
        this.listo = listo;
    }

    public Cola getPlan() {
        return plan;
    }

    public void setPlan(Cola plan) {
        this.plan = plan;
    }

    public Cola getBloq() {
        return bloq;
    }

    public void setBloq(Cola bloq) {
        this.bloq = bloq;
    }

    public Cola getTerminado() {
        return terminado;
    }

    public void setTerminado(Cola terminado) {
        this.terminado = terminado;
    }

    public Cola getListoSuspendido() {
        return listoSuspendido;
    }

    public void setListoSuspendido(Cola listoSuspendido) {
        this.listoSuspendido = listoSuspendido;
    }

    public Cola getBloqSuspendido() {
        return bloqSuspendido;
    }

    public void setBloqSuspendido(Cola bloqSuspendido) {
        this.bloqSuspendido = bloqSuspendido;
    }   

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    

    
    
}