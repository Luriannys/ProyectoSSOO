package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Nodo {

    //Atributos
    int num;
    Proceso proceso;
    Nodo anterior, siguiente;
    //Metodos

    public Nodo() {
    }
    
    public Nodo(Proceso proceso) {
        this.num = num;
        this.proceso = proceso;
        this.anterior = null;
        this.siguiente = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
