/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Semaforo {
    boolean contador =true;
    
    
    public void adquirir(){
        if (contador){
            contador=false;
        }else{
            System.out.println("No hay acceso");
        }
    }
    public void esperar(){
        if(!contador){
            contador=true;
        }
        
    }

    public boolean getContador() {
        return contador;
    }

    public void setContador(boolean contador) {
        this.contador = contador;
    }
    
}
