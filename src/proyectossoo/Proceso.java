package proyectossoo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rgabr
 */
public class Proceso {
    String nombre;
    int cantidad_instrucciones;
    boolean CPU_bound;
    boolean ES_bound;
    int registros;
    String estado;
    //Estado (Listo,Bkoqueado,Ejecutar,bloqueado suspendido, listo suspendido)
    int ID ;
    //si esbound 
    int cicloex;
    int ciclofinex;
    //CPU cpu;
    

 

    public void getPCB(){
        this.getRegistros();
        this.getID();
        this.getNombre();
        this.getEstado();
        //this.getMAR();
        //this.getPC();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int registros) {
        this.registros = registros;
    }
    
    
    public int getCicloex() {
        return cicloex;
    }

    public void setCicloex(int cicloex) {
        this.cicloex = cicloex;
    }

    public int getCiclofinex() {
        return ciclofinex;
    }

    public void setCiclofinex(int ciclofinex) {
        this.ciclofinex = ciclofinex;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_instrucciones() {
        return cantidad_instrucciones;
    }

    public void setCantidad_instrucciones(int cantidad_instrucciones) {
        this.cantidad_instrucciones = cantidad_instrucciones;
    }

    public boolean getCPU_bound() {
        return CPU_bound;
    }

    public void setCPU_bound(boolean CPU_bound) {
        this.CPU_bound = CPU_bound;
    }

    public boolean getES_bound() {
        return ES_bound;
    }

    public void setES_bound(boolean ES_bound) {
        this.ES_bound = ES_bound;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
