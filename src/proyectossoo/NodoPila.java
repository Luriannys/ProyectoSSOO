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
        this.siguiente = null;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}
