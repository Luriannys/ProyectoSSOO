package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Semaforo {

    boolean contador = true;

    public void bloquear() {
        if (contador) {
            contador = false;
        }
    }

    public void desbloquear() {
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
