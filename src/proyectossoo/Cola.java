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
        Nodo mini;
        Nodo sig, actual;
        Cola aux = new Cola("aux");
        mini= this.getCabeza();
        actual=this.getCabeza();
        sig=this.getCabeza().getSiguiente();
        int i;
        for (i=0;i<this.getTamano();i++){
            if(sig.getProceso().getCantidad_instrucciones()<actual.getProceso().getCantidad_instrucciones()){
                
                mini=sig;
                aux.add(aux,mini);
                
                
                     
         
                
            }
        }
    }
    public void add(Cola cola,Nodo nodo){
        if(cola.getTamano()==0){
            cola.setCabeza(nodo);
            cola.setCola(nodo);
            
           
        }else{
            cola.getCola().setSiguiente(nodo);
            cola.setCola(nodo);
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
