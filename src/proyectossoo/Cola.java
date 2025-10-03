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

    public Cola(String nombre, Nodo cabeza, Nodo cola, int tamano ) {
        this.nombre = nombre;
        this.cabeza = cabeza;
        this.cola = cola;
        this.tamano = tamano;
        
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
