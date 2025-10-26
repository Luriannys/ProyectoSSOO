package proyectossoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    Semaforo sf= new Semaforo();
    Nodo n = new Nodo();
    long tiempo_cpu=0;
    int pc=0;
    MetricasRendimiento mr=new MetricasRendimiento();

    @Override
    public void run() {
        this.iniciar(tiempo);

    }

    public void iniciar(long tiempo) {
        
        Proceso p1 = new Proceso("Proceso 0", 10, "CPU Bound", 0,0 ,1);
        sch.agregar_listo(p1);
//        Proceso p2 = new Proceso("b", 13, "I/O Bound", 0, 0, 1);
  //      sch.agregar_listo(p2);
    //    Proceso p3 = new Proceso("c", 5, "CPU", 4, 3);
    //    sch.agregar_listo(p3);
      //  Proceso p4 = new Proceso("d", 90, "CPU", 0, 0);
        //sch.agregar_listo(p4);

//        PC pc = new PC(listo);
//        pc.siguiente_proceso(listo);

        while (true) {     
            sch.politica_planificacion(this.getSch().getPlan());
            while (!sch.listo.estaVacia()) {
                mr.registrarCPUOcupada(tiempo_cpu);
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
        int u = this.sch.getCiclosRR();

        Proceso p1 = sch.getListo().getCabeza().getProceso();
        pc++;
        n.setProceso(p1);
        //Proceso p2=this.getListo().getCabeza().getSiguiente().getProceso();
        listo.desencolar();

        Thread t1 = new Thread();
        t1.start();
        int i;
        int v = p1.getCantidad_instrucciones();
        int e = p1.getCiclofinex();
        p1.setEstado("Ejecutando");
        n.setProceso(p1);
        
        sf.bloquear();
        //poner el ciclo de excepcion 
        System.out.println("Procesando " + p1.getNombre());
        getLogList().apilar(new NodoPila("Procesando " + p1.getNombre()));

        if (e > 0) {

            for (i = 0; i < e; i++) {
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                
               if(p1.getCantidad_instrucciones()<=0){
                   mr.registrarProcesoCompletado(tiempo, tiempo_cpu);
                sch.terminar_proceso(p1);
                System.out.println("Proceso Terminado");
                sf.desbloquear();
                break;
            
               }
                System.out.println(p1.getCantidad_instrucciones());
                this.tiempo_cpu++;
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
                    System.out.println("Se te acabo el tiempo ");
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
           
            sf.bloquear();
            for (i = 0; i < v; i++) {
                this.tiempo_cpu++;
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                if (p1.getCantidad_instrucciones() <= 0) {
                mr.registrarProcesoCompletado(tiempo, tiempo_cpu);
                sch.terminar_proceso(p1);
                System.out.println("Proceso Terminado");
                getLogList().apilar(new NodoPila("Proceso terminado: " + p1.getNombre()));
                sf.desbloquear();
                break;
               
            }
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
                    System.out.println("Se te acabo el tiempo ");
                    sf.desbloquear();

                    break;
                }
                if (p1.getCantidad_instrucciones() == 0) {
                     mr.registrarProcesoCompletado(tiempo, tiempo_cpu);
                sch.terminar_proceso(p1);
                sf.desbloquear();
                System.out.println("Proceso Terminado");
                getLogList().apilar(new NodoPila("Proceso terminado: " + p1.getNombre()));
                break;

                
            }
            }
            

        }

    }

    public void ejecutar_p(Cola bloq, Cola listo) {

        Proceso p1 = sch.getListo().getCabeza().getProceso();
        n.setProceso(p1);
        pc++;
        //Proceso p2=this.getListo().getCabeza().getSiguiente().getProceso();
        listo.desencolar();
        
        Thread t1 = new Thread();
        t1.start();
        int i;
        int v = p1.getCantidad_instrucciones();
        int e = p1.getCiclofinex();
        p1.setEstado("Ejecutando");
        n.setProceso(p1);
        //poner el ciclo de excepcion 
        System.out.println("Procesando " + p1.getNombre());
        getLogList().apilar(new NodoPila("Procesando " + p1.getNombre()));

        sf.bloquear();
        
        if (e > 0) {

            for (i = 0; i < e; i++) {
               this.tiempo_cpu++;
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                if (p1.getCantidad_instrucciones() <= 0) {
                sch.terminar_proceso(p1);
                 mr.registrarProcesoCompletado(tiempo, tiempo_cpu);
                System.out.println("Proceso Terminado");
                getLogList().apilar(new NodoPila("Proceso terminado: " + p1.getNombre()));
                break;

            }
                System.out.println(p1.getCantidad_instrucciones());
                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }sf.desbloquear();
            System.out.println("Bloqueado");

            sch.bloquear_proceso(p1);

            //se mueve a cola de bloqueado
            //metodo del scheduler que movera el proceso a bloqueado
        } else {
            System.out.println("Ejecutando");
            sf.bloquear();
            for (i = 0; i < v; i++) {
                this.tiempo_cpu++;
                
                p1.setCantidad_instrucciones(p1.getCantidad_instrucciones() - 1);
                p1.setEstado("Ejecutando");
                n.setProceso(p1);

                try {
                    //aqui el hilo espera el tiempo del ciclo
                    t1.sleep(Duration.ofSeconds(tiempo));
                } catch (InterruptedException ex) {
                    System.getLogger(CPU.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                System.out.println(p1.getCantidad_instrucciones());
                if (p1.getCantidad_instrucciones() <= 0) {
                     mr.registrarProcesoCompletado(tiempo, tiempo_cpu);
                sch.terminar_proceso(p1);
                System.out.println("Proceso Terminado");
                getLogList().apilar(new NodoPila("Proceso terminado: " + p1.getNombre()));
                    break;
                }
                

                }
            }sf.desbloquear();
            
        
    }

    // Lee datos de CSV632
    public Long leerDatos() {
        Long tiempoCiclo = 0L;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("configuracion.csv"));
            String ciclo = reader.readLine();
            String ciclo_sin_pcomas = ciclo.replaceAll("[^0-9]", "");
            tiempoCiclo = Long.valueOf(ciclo_sin_pcomas);
            for (int i = 0; i < 40; i++) {
                String proceso = reader.readLine();
                Lista partes = splitt(proceso);
                Proceso p = new Proceso(
                        partes.getpFirst().getTexto(), //nombre
                        Integer.parseInt(partes.getpFirst().getSiguiente().getTexto()), // cantidad de instrucciones
                        partes.getpFirst().getSiguiente().getSiguiente().getTexto(), // bound
                        Integer.parseInt(partes.getpFirst().getSiguiente().getSiguiente().getSiguiente().getTexto()),// cicloex
                        Integer.parseInt(partes.getpFirst().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getTexto()));// finex
                getSch().agregar_listo(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiempoCiclo;
    }

    public void guardarDatos(Long nuevoTiempoCiclo) {
        String[] lineas = new String[41]; // 1 línea de tiempo + 40 procesos
        int contador = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("configuracion.csv"));
            String linea;

            while ((linea = reader.readLine()) != null && contador < 41) {
                if (contador == 0) {
                    lineas[contador] = String.valueOf(nuevoTiempoCiclo); // reemplaza la primera línea
                } else {
                    lineas[contador] = linea; // conserva el resto
                }
                contador++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("configuracion.csv"));
            for (int i = 0; i < contador; i++) {
                writer.write(lineas[i]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Arregla datos del CSV para manipularlos
    public Lista splitt(String cadena) {
        String palabra = "";
        Lista resultado = new Lista();
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if (letra != ';') {
                palabra += letra;
            } else {
                resultado.addAtTheEnd(new NodoPila(palabra));
                palabra = "";
            }
        }
        return resultado;
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

    public int getTiempo_cpu() {
        return tiempo_cpu;
    }

    public void setTiempo_cpu(int tiempo_cpu) {
        this.tiempo_cpu = tiempo_cpu;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

}
