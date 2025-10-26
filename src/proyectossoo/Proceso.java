package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Proceso {

    String nombre;
    int cantidad_instrucciones;
    int cantidad_instrucciones_iniciales;
    String bound;
    int registros;
    String estado;
    //Estado (nuevo, Listo,Bloqueado,Ejecutar,terminado, suspendido)
    int ID;
    int MAR;
    //si esbound 
    int cicloex;
    int ciclofinex;
    int tiempoLlegada;
    int prioridad ;
    

    /* public Proceso(String nombre, int cantidad_instrucciones, String bound) {
        this.nombre = nombre;
        this.cantidad_instrucciones = cantidad_instrucciones;
        this.bound = bound;
        this.estado = "Nuevo";
    }*/
    public double calcularFactorRespuesta(Long tiempoActual) {
        // Tiempo de Espera (Tw) = Tiempo Actual (T) - Tiempo de Llegada (Ta)
        Long tiempoEspera = tiempoActual; 
        
        // HRRN Ratio = (Tw + Ts) / Ts
        // donde Ts = cantidadInstrucciones
        
        if (this.cantidad_instrucciones == 0) {
            // Prevenir división por cero si la ráfaga es 0 (caso teórico, pero seguro)
            return Double.MAX_VALUE;
        }

        // El cálculo debe ser con números de punto flotante (double) para precisión
        return (double) (tiempoEspera + this.cantidad_instrucciones) / this.cantidad_instrucciones;
    }
    public Proceso(String nombre, int cantidad_instrucciones, String bound, int cicloex, int ciclofinex) {
        this.nombre = nombre;
        this.cantidad_instrucciones = cantidad_instrucciones;
        this.cantidad_instrucciones_iniciales=cantidad_instrucciones;
        this.bound = bound;
        this.estado = "Nuevo";
        this.cicloex = cicloex;
        this.ciclofinex = ciclofinex;
        this.prioridad = 0;
    }
    public Proceso(String nombre, int cantidad_instrucciones, String bound, int cicloex, int ciclofinex,int prioridad) {
         this.nombre = nombre;
        this.cantidad_instrucciones = cantidad_instrucciones;
         this.cantidad_instrucciones_iniciales=cantidad_instrucciones;
        this.bound = bound;
        this.estado = "Nuevo";
        this.cicloex = cicloex;
        this.ciclofinex = ciclofinex;
        this.prioridad=prioridad;
    }

    public void crearProcesos(String nombre, int cantidad_instrucciones, String bound) {
        Proceso p1 = new Proceso(nombre, cantidad_instrucciones, bound, 0, 0);

    }

    public String getPCBLog() {
        this.getRegistros();
        this.getID();
        this.getNombre();
        this.getEstado();
        //this.getMAR();
        //this.getPC();
        return "<html>" + "<br>Nombre: " + getNombre() + "<br>Estado: " + getEstado() + "<br>Tamaño: " + Integer.toString(getCantidad_instrucciones_iniciales()) + "<br>Tipo: " + getBound() + "<br>----------------------------" + "</html>";
    }

    public String getPCB() {
        this.getRegistros();
        this.getID();
        this.getNombre();
        this.getEstado();
        //this.getMAR();
        //this.getPC();
        return "<html>" + "<br>Nombre: " + getNombre() + "<br>Tamaño: " + Integer.toString(getCantidad_instrucciones_iniciales()) + "<br>Tipo: " + getBound() + "<br>----------------------------" + "</html>";
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

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCantidad_instrucciones_iniciales() {
        return cantidad_instrucciones_iniciales;
    }

    public void setCantidad_instrucciones_iniciales(int cantidad_instrucciones_iniciales) {
        this.cantidad_instrucciones_iniciales = cantidad_instrucciones_iniciales;
    }

    public int getMAR() {
        return MAR;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }

    

   

}
