package interfaces;

import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import proyectossoo.CPU;
import proyectossoo.Cola;
import proyectossoo.Nodo;
import proyectossoo.NodoPila;

/**
 *
 * @author Luri
 */
public class Controlador extends Thread {

    private CPU cpu = new CPU();
    private View view = new View(this);
    private volatile long segundos = 0L;

    public Controlador() {
        this.start();
        view.setVisible(true);
    }

    public DefaultListModel createModel(Cola cola) {
        DefaultListModel model = new DefaultListModel();
        Nodo actual = cola.getCabeza();
        while (actual != null) {
            model.addElement(actual.getProceso().getPCB());
            actual = actual.getSiguiente();
        }
        return model;
    }

    @Override
    public void run() {

         //Reloj/Cronometro
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    long inicio = System.currentTimeMillis(); // Marca de tiempo inicial
                    while (true) {
                        try {
                            Thread.sleep(500);
                            long ahora = System.currentTimeMillis();
                            long transcurrido = ahora - inicio;

                            // Convertimos milisegundos a horas, minutos y segundos
                            long segundos = (transcurrido / 1000);
                            long horas = (segundos / 3600);
                            long minutos = ((segundos % 3600) / 60);
                            long seg = (segundos % 60);

                            // Formateamos como HH:mm:ss
                            String tiempo = String.format("%02d:%02d:%02d", horas, minutos, seg);
                            getView().getClockLabel().setText(tiempo);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        
        while (true) {

            //Proceso que esta corriendo
            if (cpu.getN() != null && cpu.getN().getProceso() != null) {
                String actualprocess = cpu.getN().getProceso().getPCB() ;
                view.getRunningLabel().setText(actualprocess);
                view.getPCLabel().setText("PC: " + String.valueOf(cpu.getPc()));
            }

            cpu.setTiempo((long) view.getCycleDuration().getValue());   
            cpu.getSch().setTiempo((long) view.getCycleDuration().getValue());
            cpu.getSch().setTranscurrido(segundos);

            //Visualizacion de la etiqueta politica de planificacion
            view.getPlanPolicy().setText("Política de planificación: " + (String) view.getPlanificationPolicy().getSelectedItem());

            //Seleccion de la politica de planificacion
            cpu.getSch().politica_planificacion((String) view.getPlanificationPolicy().getSelectedItem());
            cpu.getLogList().apilar(new NodoPila("Planificación seleccionada: " + (String) view.getPlanificationPolicy().getSelectedItem()));


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
