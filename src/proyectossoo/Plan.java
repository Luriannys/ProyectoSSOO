/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class Plan {
    //Van los 6 tipos de planes 
    //Capaz se meto todo en la clase cola
    //Atributos
    Cola listo;
    int plan;
    int ciclosRR;
    int rq;
    int tamanolista;
    //Metodos
    public void selec_plan(){
        this.setTamanolista(this.getListo().getTamano());
        if (this.getTamanolista()>0){
            
        switch(plan){
                     
        
            case 1://FIFO
                //devuelve la cola listo normal 
                this.getListo();
                break;
            case 2://RR
                //Utilizar ciclos para determinar el tiempo de ejecucion tiempo determinado si tarda mucho se cambia
                this.getListo();
                break;
            case 3://SPN
                //Utiliza la cantidad de instrucciones y agarra el mas corto
                          
                            
                break;
            case 4://SRT
                //este chequea si un proceso nuevo es mas corto que el que esta en ejecucion y los cambia
                break;
            case 5://HRRN
                // Utiliza la cantidad de instrucciones y agarra el mas corto si un proceso espera mucho se sube su prioridad 
                break;
            case 6://FEEDBACK
                // cada vez que se ejecute un proceso su rq pasa de 0 a 1 si se vuelve a ejecutar se le baja la prioridad
                //si llega a la mas baja se aplica RR
                break;
        }
        }
    }

    public int getTamanolista() {
        return tamanolista;
    }

    public void setTamanolista(int tamanolista) {
        this.tamanolista = tamanolista;
    }

    public Cola getListo() {
        return listo;
    }

    public void setListo(Cola listo) {
        this.listo = listo;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getCiclosRR() {
        return ciclosRR;
    }

    public void setCiclosRR(int ciclosRR) {
        this.ciclosRR = ciclosRR;
    }

    public int getRq() {
        return rq;
    }

    public void setRq(int rq) {
        this.rq = rq;
    }
    
}
