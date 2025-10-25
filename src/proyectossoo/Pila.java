
package proyectossoo;

import javax.swing.DefaultListModel;

/**
 *
 * @author Luri
 */
public class Pila {
    
    NodoPila cima;
    int size;

    public Pila() {
        this.cima = null;
    }

    // Revisar si esta vacia
    public boolean estaVacia() {
        return cima == null;
    }
    
    //Apilar (es la unica que se necesita para el log de eventos)
    public void apilar(NodoPila newNodo){
        if (!estaVacia()){
            newNodo.setSiguiente(getCima());
            setCima(newNodo);
        } else {
            setCima(newNodo);
        }
        size++;
    }
    
    public DefaultListModel createModel(){
        DefaultListModel model = new DefaultListModel();
        NodoPila actual = this.getCima();
        while (actual != null){
            model.addElement(actual.getTexto());
            actual = actual.getSiguiente();
            }
        return model;
    }
    
    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    public int getSize() {
        return size;
    }
   
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
    
    
    
}
