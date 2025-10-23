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
        View v = new View();
        v.setVisible(true);
        long tiempo = 5;
        int memoria = 1000000000;
        Cola listo= new Cola("Listo");
        PC pc=new PC(listo);
        CPU cpu=new CPU();
        
       Scheduler a= new Scheduler();
       a.iniciar(tiempo);
       
    }
    
}
