package proyectossoo;

import java.util.HashSet;
import java.util.Set;

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
//cola de bloqueados ejecuta sus bloqueados
    public Cola(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public void addAtTheStart(Nodo newNodo) {
        if (estaVacia()) {
            setCabeza(newNodo);
            setCola(newNodo);
        } else {
            newNodo.setSiguiente(getCabeza());
            getCabeza().setAnterior(newNodo);
            setCabeza(newNodo);
        }
        tamano++;
    }
        
        public void sort() {
        if (cabeza == null) {
            return;
        }

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.getProceso().getCantidad_instrucciones() > actual.siguiente.getProceso().getCantidad_instrucciones()) {
                    // Intercambiar los valores
                    Proceso temp = actual.getProceso();
                    actual.setProceso(actual.siguiente.getProceso());
                    actual.siguiente.setProceso(temp);

                    huboIntercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (huboIntercambio);
    }

    public void add(Proceso p) {
        Nodo nodo = new Nodo(p);
        if (estaVacia()) {
            setCabeza(nodo);
            setCola(nodo);
        } else {
            getCola().setSiguiente(nodo);
            setCola(nodo);
        }
        tamano++;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public Proceso desencolar() {
        if (estaVacia()) {
            // Manejar error o devolver un valor de indicador
            throw new IllegalStateException("La cola está vacía");
        } else {
            Proceso p1 = this.getCabeza().getProceso();
            this.setCabeza(this.getCabeza().getSiguiente());
            tamano--;
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
