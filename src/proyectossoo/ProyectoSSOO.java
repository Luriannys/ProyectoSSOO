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
        //tiempo
        //memoria
        Proceso p1 = new Proceso("p1",15,"CPUBound");
        Cola listo = new Cola("Listo");
        listo.add(p1);
        
    }
    
}
