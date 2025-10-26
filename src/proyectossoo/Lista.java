
package proyectossoo;

/**
 *
 * @author Luriannys Junco
 */
public class Lista {

    private NodoPila pFirst;
    private NodoPila pLast;
    private int size;

    /**
     * Constructor
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Metodo que verifica si la lista esta vacia
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return pFirst == null;
    }

    /**
     * Vacia la lista
     */
    public void empty() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Metodo que agrega un nodo al final de la lista
     *
     * @param newNodo
     */
    public void addAtTheEnd(NodoPila newNodo) {
        if (this.isEmpty()) {
            pFirst = pLast = newNodo;
        } else {
            pLast.setSiguiente(newNodo);
            pLast = newNodo;
        }
        size++;
    }
    
    /**
     * Metodo que agrega un nodo al inicio de la lista
     * @param newNodo 
     */
    public void addAtTheStart(NodoPila newNodo){
        if (this.isEmpty()) {
            pFirst = pLast = newNodo;
        } else {
            newNodo.setSiguiente(getpFirst());
            setpFirst(newNodo);
        }
        size++;
    }

    /**
     *Metodo que elimina un nodo al inicio de la lista
     */
    public void DeleteAtTheStart(){
        if(!this.isEmpty()){
            if(size == 1){
                this.empty();
            } else {
                pFirst = pFirst.getSiguiente();
                size--;
            }
        }
    }
    
    /**
     * Metodo que imprime cada nodo de la lista
     */
    public void print(){
        NodoPila temp = pFirst;
        if (this.isEmpty()){
            System.out.println("The list is empty.");
        }
        while(temp != null){
            System.out.println(temp);
            temp = temp.getSiguiente();
        }
    }
       
    /**
     * @return pFirst
     */
    public NodoPila getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst 
     */
    public void setpFirst(NodoPila pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return pLast
     */
    public NodoPila getpLast() {
        return pLast;
    }

    /**
     * @param pLast 
     */
    public void setpLast(NodoPila pLast) {
        this.pLast = pLast;
    }

    /**
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
}