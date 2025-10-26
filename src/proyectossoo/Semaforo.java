package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Semaforo {

    boolean contador = true;

    public void adquirir() {
        if (contador) {
            contador = false;
        } else {
            System.out.println("No hay acceso");
        }
    }

    public void esperar() {
        if (!contador) {
            contador = true;
        }

    }

    public boolean getContador() {
        return contador;
    }

    public void setContador(boolean contador) {
        this.contador = contador;
    }

}
