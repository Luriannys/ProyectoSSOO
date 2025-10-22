/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Cola {
    //Atributos 
    String nombre;
    Nodo cabeza;
    Nodo cola;
    int tamano;
    /*listo, new, bloqueado, suspendido listo,suspendido bloqueado,largo,corto,mediano plazo,terminados*/
    //Metodos

    public Cola(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

      
    

   
    

    public void mas_pequeno(){
        if (estaVacia()){
            return;
        }
        Cola colaAuxiliar = new Cola("a");
       // int tamano = 0;
        Nodo temp = cabeza;
       /* while (temp != null) {
            tamano++;
            temp = temp.siguiente;
        }*/
        for (int i = 0; i < getTamano(); i++) {
            Proceso min = desencolar();
            int restantes = getTamano() - (i + 1);
            
            for (int j = 0; j < restantes; j++) {
                Proceso actual = desencolar();
                if (actual.getCantidad_instrucciones() < min.getCantidad_instrucciones()) {
                add(min);
                min = actual;
            } else {
                add(actual);
            }
        }
        colaAuxiliar.add(min);
    }

    while (!colaAuxiliar.estaVacia()) {
        add(colaAuxiliar.desencolar());
    }
                     
         
                
            }
    
    
    

  
    public void add(Proceso p){
         Nodo nodo = new Nodo(p);
        if(estaVacia()){
            setCabeza(nodo);
            setCola(nodo);          
        }else{
            getCola().setSiguiente(nodo);
            setCola(nodo);
        }
        this.tamano=tamano++;
    }
    
    public void add_listo(Proceso p){
        Nodo nodo = new Nodo(p);
        if(estaVacia()){
            setCabeza(nodo);
            setCola(nodo);          
        }else{
            getCola().setSiguiente(nodo);
            setCola(nodo);
        }
        p.setEstado("Listo");
        this.setTamano(this.getTamano()+1);
    }
    
      public boolean estaVacia() {
        return cabeza == null;
    }
    public Proceso desencolar(){
        if (estaVacia()) {
        // Manejar error o devolver un valor de indicador
            throw new IllegalStateException("La cola está vacía"); 
        }else{
            Proceso p1 = this.getCabeza().getProceso();
            this.setCabeza(this.getCabeza().getSiguiente());
            this.setTamano(tamano-1);
        if (this.getCabeza() == null) {
            this.setCola(null);
        }
            return p1;
        }
        
    }
        
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public int getTamano() {
        return tamano;
    }

 
    
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
