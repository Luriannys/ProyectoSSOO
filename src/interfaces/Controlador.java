package interfaces;

import javax.swing.DefaultListModel;
import proyectossoo.CPU;
import proyectossoo.Cola;
import proyectossoo.Nodo;

/**
 *
 * @author Luri
 */
public class Controlador extends Thread {

    private CPU cpu = new CPU();
    private View view = new View(this);

    public Controlador() {
        view.setVisible(true);
        cpu.setTiempo((long) view.getCycleDuration().getValue());
        cpu.getSch().setTiempo((long) view.getCycleDuration().getValue());
    }

    public DefaultListModel createModel(Cola cola) {
        DefaultListModel model = new DefaultListModel();
        Nodo actual = cola.getCabeza();
        while (actual != null) {
            model.addElement(actual.getProceso().getNombre());
            actual = actual.getSiguiente();
        }
        return model;
    }

    @Override
    public void run() {

        while (true) {

            //Proceso que esta corriendo
            //String actualprocess = (String) cpu.getPc().getP_actual().getPCB();
            //runningLabel.setText(actualprocess);
            
            //Visualizacion de la etiqueta politica de planificacion
            view.getPlanPolicy().setText("Política de planificación: " + (String)view.getPlanificationPolicy().getSelectedItem());
            
            //Seleccion de la politica de planificacion
            cpu.getSch().politica_planificacion((String)view.getPlanificationPolicy().getSelectedItem());
                       
            //Log de eventos
            if (cpu.getLogList().createModel() != view.getLogList().getModel()) {
                DefaultListModel eventLogList = cpu.getLogList().createModel();
                view.getLogList().setModel(eventLogList);
            }

            //Cola de listos
            if (createModel(cpu.getSch().getListo()) != view.getReadys().getModel()) {
                DefaultListModel modelReady = createModel(cpu.getSch().getListo());
                view.getReadys().setModel(modelReady);
            }

            //Cola de bloqueados
            if (createModel(cpu.getSch().getBloq()) != view.getBlocked().getModel()) {
                DefaultListModel modelBlocked = createModel(cpu.getSch().getBloq());
                view.getBlocked().setModel(modelBlocked);
            }

            //Cola de listos suspendidos
            if (createModel(cpu.getSch().getListoSuspendido()) != view.getSuspendedReadys().getModel()) {
                DefaultListModel modelSuspendedReady = createModel(cpu.getSch().getListoSuspendido());
                view.getSuspendedReadys().setModel(modelSuspendedReady);
            }

            //Cola de listos bloqueados
            if (createModel(cpu.getSch().getBloqSuspendido()) != view.getSuspendedBlocked().getModel()) {
                DefaultListModel modelSuspendedBlocked = createModel(cpu.getSch().getBloqSuspendido());
                view.getSuspendedBlocked().setModel(modelSuspendedBlocked);
            }

            //Cola de terminados
            if (createModel(cpu.getSch().getTerminado()) != view.getFinished().getModel()) {
                DefaultListModel modelFinished = createModel(cpu.getSch().getTerminado());
                view.getFinished().setModel(modelFinished);
            }
        }
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

}
