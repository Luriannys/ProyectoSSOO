package proyectossoo;

import java.util.Set;

/**
 *
 * @author rgabr
 */
public class Scheduler implements Runnable {

    int memoria=100;
    
    long tiempo;
    Cola listo = new Cola("Listo");
    Cola bloq = new Cola("Bloqueado");
    Cola terminado = new Cola("Terminado");
    Cola listoSuspendido = new Cola("Listo suspendido");
    Cola bloqSuspendido = new Cola("Bloqueado suspendido");
    Cola plan = new Cola("Plan");
    Semaforo sfbloq = new Semaforo();
    Semaforo sflisto = new Semaforo();
    Cola p0 = new Cola("Prioridad alta");
    Cola p1 = new Cola("Prioridad baja");
    int ciclosRR=0;

    @Override
    public void run() {
        while (true) {
            this.espera_bloqueados();
        }

    }

    // Agregar proceso a cola Listo
    public void agregar_listo(Proceso p) {
        int nueva_memoria = memoria - p.getCantidad_instrucciones();
        if (nueva_memoria < 0) {
            setMemoria(0);
            this.suspender_listo(p);
            
       }else {
            setMemoria(nueva_memoria);
            listo.add(p);
            p.setEstado("Listo");
        }
    }
        
            
        

    // Terminar proceso y agregar a cola Terminados
    public void terminar_proceso(Proceso p) {
        p.setEstado("Terminado");
        terminado.add(p);
    }

    // Bloquear proceso
    public void bloquear_proceso(Proceso p) {
        p.setEstado("Bloqueado");
        bloq.add(p);
        
    }

    // Suspender proceso listo
    public void suspender_listo(Proceso p) {
        p.setEstado("Listo suspendido");
        listoSuspendido.add(p);
        this.setMemoria(memoria+p.getCantidad_instrucciones());
        
    }

    // Suspender proceso bloqueado
    public void suspender_bloqueado(Proceso p) {
        p.setEstado("Bloqueado suspendido");
        bloqSuspendido.add(p);
        this.setMemoria(memoria+p.getCantidad_instrucciones());
    }

    // Cambiar politica de planificacion
    public void politica_planificacion(String s) {
        switch (s) {
            case "FIFO" -> {
                // LOGICA FIFO
//                int i;
//                int e = this.getPlan().getTamano();
//                for (i = 0; i < e; i++) {
//                    if ("Nuevo"!=this.getPlan().getCabeza().getProceso().getEstado()){
//                        
//                    }
//                    this.agregar_listo(this.getPlan().getCabeza().getProceso());
//                    this.getPlan().desencolar();
//                }
            }
            case "Round Robin" -> {
                // LOGICA ROUND ROBIN
                this.setCiclosRR(5);
//                int i;
//                int e = this.getPlan().getTamano();
//                for (i = 0; i < e; i++) {
//                    this.agregar_listo(this.getPlan().getCabeza().getProceso());
//                    this.getPlan().desencolar();
//                }
            }
            case "SPN" -> {
                // LOGICA SPN
             this.getListo().sort();
//             int i;
//                int e = this.getListo().getTamano();
//                for (i = 0; i < e; i++) {
//                    this.agregar_listo(this.getPlan().getCabeza().getProceso());
//                    this.getPlan().desencolar();
//                }
            }
            case "SRT" -> {
                // LOGICA SRT
                this.getPlan().sort();
//                int i;
//                int e = this.getPlan().getTamano();
//                for (i = 0; i < e; i++) {
//                    this.agregar_listo(this.getPlan().getCabeza().getProceso());
//                    this.getPlan().desencolar();
//                }
            }
            case "HRRN" -> {
                // LOGICA HRRN
                
                
                
                    
                
            }
            case "Realimentación" -> {
                // LOGICA REALIMENTACION
                int i;
                this.setCiclosRR(5);
                
                int e = this.getListo().getTamano();
                for (i = 0; i < e; i++) {
                    if(this.getListo().getCabeza().getProceso().getPrioridad()==0){
                        this.getP0().add(this.getListo().getCabeza().getProceso());
                    }else if(this.getListo().getCabeza().getProceso().getPrioridad()==1){
                         this.getP1().add(this.getListo().getCabeza().getProceso());
                    }else{
                        this.getP1().add(this.getListo().getCabeza().getProceso());
                    }
                    this.getListo().desencolar();
                }
                int p0=this.getP0().getTamano();
                int p1=this.getP0().getTamano();
                if(p0!=0){
                    for(i=0;i<p0;i++){
                    this.agregar_listo(this.getP0().getCabeza().getProceso());
                    this.getP0().desencolar();
                }
                }
                if(p1!=0){
                for(i=0;i<p1;i++){
                    this.agregar_listo(this.getP1().getCabeza().getProceso());
                    this.getP1().desencolar();
                }
                }
            }
            default -> {

            }
        }
    }
    public static Nodo seleccionarProcesoHRRN(Nodo cabeza, int tiempoActual) {
        
        if (cabeza == null) {
            return null;
        }

        // 1. Inicializar con el nodo cabeza
        Nodo nodoSeleccionado = cabeza;
        // Calcular el Factor de Respuesta del primer proceso
        double mayorFactorRespuesta = cabeza.getProceso().calcularFactorRespuesta(tiempoActual);

        // 2. Iterar sobre el resto de la lista
        Nodo actual = cabeza.getSiguiente();

        while (actual != null) {
            // 3. Calcular el factor de respuesta para el proceso actual
            double factorActual = actual.getProceso().calcularFactorRespuesta(tiempoActual);
            
            // 4. Comparar: HRRN selecciona el MÁS ALTO (mayor)
            if (factorActual > mayorFactorRespuesta) {
                mayorFactorRespuesta = factorActual;
                nodoSeleccionado = actual;
            }
            
            actual = actual.getSiguiente();
        }

        return nodoSeleccionado;
    }
    public void SPN(){
        /*static void sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
         for(int i=0; i < n; i++){
                 for(int x=1; x < (n-i); x++){
                          if(arr[x-1] > arr[x]){
                                 temp = arr[x-1];
                                 arr[x-1] = arr[x];
                                 arr[x] = temp;
                         }

                 }
         }*/
                    int n =this.getPlan().getTamano();
                    Proceso temp= new Proceso("aux",0,"", 0, 0);
                    this.getPlan().addAtTheStart(new Nodo());
                    Nodo aux = this.getPlan().getCabeza();
                            
//                    for (int i=0;i<n;i++){
//                        for(int x=1;x<(n-i);x++){
//                            if(this.getPlan().getCabeza().getProceso().getCantidad_instrucciones()>this.getPlan().getCabeza().getSiguiente().getProceso().getCantidad_instrucciones()){
//                                temp=this.getPlan().getCabeza().getProceso();
//                                this.getPlan().setCabeza(this.getPlan().getCabeza().getSiguiente());
//                                this.getPlan().getCabeza().getSiguiente().setProceso(temp);
//                            }
//                        }
//                    }

//                    static void ordenarBurbuja(Nodo cabeza) {
//    if (cabeza == null) return;
//
//    boolean huboIntercambio;
//    do {
//        huboIntercambio = false;
//        Nodo actual = cabeza;
//
//        while (actual.siguiente != null) {
//            if (actual.valor > actual.siguiente.valor) {
//                // Intercambiar los valores
//                int temp = actual.valor;
//                actual.valor = actual.siguiente.valor;
//                actual.siguiente.valor = temp;
//
//                huboIntercambio = true;
//            }
//            actual = actual.siguiente;
//        }
//    } while (huboIntercambio);
//}
                    for (int i=0;i<n;i++){
                        for(int x=1;x<(n-i);x++){
                            if (aux.getSiguiente() != null){
                                aux = aux.getSiguiente();
                                if(aux.getProceso().getCantidad_instrucciones()>aux.getSiguiente().getProceso().getCantidad_instrucciones()){
                                temp=aux.getProceso();
                                aux.setProceso(aux.getSiguiente().getProceso());
                                aux.getSiguiente().setProceso(temp);
                                
                            }
                        } else {
                            break;
                            }
                            
                            
                            
                    }


//                    Proceso p1=this.getPlan().getCabeza().getProceso();
//                    Proceso p2 = this.getPlan().getCabeza().getSiguiente().getProceso();
//                    if(p1.getCantidad_instrucciones()>p2.getCantidad_instrucciones()){
//                       this.getPlan().desencolar();
//                       this.getPlan().add(p1);
//                        
//                        SPN();
                       
                        
                    
                
                
                    }}
    public Proceso spn2(){
         if (this.getPlan().getCabeza()== null) {
              
            return null;
         }
        Nodo nodoSeleccionado = this.getPlan().getCabeza();
        int menorInstrucciones = this.getPlan().getCabeza().getProceso().getCantidad_instrucciones();
        
        Nodo actual = this.getPlan().getCabeza().getSiguiente();

        while (actual != null) {
            int instruccionesActuales = actual.getProceso().getCantidad_instrucciones();
              if (instruccionesActuales < menorInstrucciones) {
                menorInstrucciones = instruccionesActuales;
                nodoSeleccionado = actual;
            }
              actual = actual.getSiguiente();
        }
        
        return nodoSeleccionado.getProceso();
    }
    public void espera_bloqueados() {
        Thread t2 = new Thread();

        if (bloq.getTamano() == 0) {

            System.out.println("no hay bloqueados");
            try {
                //aqui el hilo espera el tiempo del ciclo
                t2.sleep(tiempo * 1000);
            } catch (InterruptedException ex) {
                System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

        } else {
            t2.start();
            System.out.println("Procesando bloqueado");
            int i;
            int v = this.getBloq().getCabeza().getProceso().getCiclofinex();
            for (i = 0; i < v; i++) {
                this.getBloq().getCabeza().getProceso().setCiclofinex(this.getBloq().getCabeza().getProceso().getCiclofinex() - 1);

                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t2.sleep(tiempo * 1000);
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                System.out.println("Bloqueado " + this.getBloq().getCabeza().getProceso().getCiclofinex());
            }
            this.agregar_listo(this.getBloq().getCabeza().getProceso());
            bloq.desencolar();
           

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

    public int getCiclosRR() {
        return ciclosRR;
    }

    public void setCiclosRR(int ciclosRR) {
        this.ciclosRR = ciclosRR;
    }

    public Scheduler() {
    }

    public Cola getP0() {
        return p0;
    }

    public void setP0(Cola p0) {
        this.p0 = p0;
    }

    public Cola getP1() {
        return p1;
    }

    public void setP1(Cola p1) {
        this.p1 = p1;
    }

   
    

    

}
