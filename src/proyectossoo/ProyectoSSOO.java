/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectossoo;
import interfaces.*;

/**
 *
 * @author luria
 */
public class ProyectoSSOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        View v = new View();
//        v.setVisible(true);
//        long tiempo = 20;
//        

        Controlador app = new Controlador();
        
          Thread t2 =new Thread(app.getCpu());
       Thread t3 = new Thread(app.getCpu().getSch());
        t2.start();
        t3.start();
        app.start();
        
        
        
       
       
    }
}
