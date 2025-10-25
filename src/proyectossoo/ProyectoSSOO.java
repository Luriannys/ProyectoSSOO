
package proyectossoo;
import interfaces.*;

/**
 *
 * @author Luri
 */
public class ProyectoSSOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Controlador app = new Controlador();
        
        Thread t2 =new Thread(app.getCpu());
        Thread t3 = new Thread(app.getCpu().getSch());
        t2.start();
        t3.start();
        app.start();
        
        
        
       
       
    }
}
