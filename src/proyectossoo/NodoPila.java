package proyectossoo;

/**
 *
 * @author Luri
 */
public class NodoPila {

    //Atributos
    String texto;
    NodoPila anterior, siguiente;

    //Metodos
    public NodoPila(String texto) {
        this.texto = texto;
        this.anterior = null;
        this.siguiente = null;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public NodoPila getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPila anterior) {
        this.anterior = anterior;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}
