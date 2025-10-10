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
    String bound;
    int registros;
    String estado;
    //Estado (nuevo, Listo,Bloqueado,Ejecutar,terminado, suspendido)
    int ID ;
    int MAR;
    PC pc;
    //si esbound 
    int cicloex;
    int ciclofinex;
    //CPU cpu;

    public Proceso(String nombre, int cantidad_instrucciones, String bound) {
        this.nombre = nombre;
        this.cantidad_instrucciones = cantidad_instrucciones;
        this.bound = bound;
        this.estado = "Nuevo";
    }
    
    

    public Proceso(String nombre, int cantidad_instrucciones, boolean CPU_bound, boolean ES_bound, int registros, String estado, int ID, int MAR, PC pc, int cicloex, int ciclofinex) {
        this.nombre = nombre;
        this.cantidad_instrucciones = cantidad_instrucciones;
        this.CPU_bound = CPU_bound;
        this.ES_bound = ES_bound;
        this.registros = registros;
        this.estado = estado;
        this.ID = ID;
        this.MAR = MAR;
        this.pc = pc;
        this.cicloex = cicloex;
        this.ciclofinex = ciclofinex;
    }
    
 

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

    public String getBound() {
        return bound;
    }

    public void setBound(String bound) {
        this.bound = bound;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
