/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectossoo;

/**
 *
 * @author rgabr
 */
public class MetricasRendimiento {
    
    private long tiempoTotalSimulado = 0;
    private long tiempoCPUOcupada = 0;
    private int procesosCompletados = 0;
    private long sumaTiemposRespuesta = 0;
    private int[] tiemposPorProceso = new int[40]; // para equidad

    public void registrarCPUOcupada(long duracion) {
        tiempoCPUOcupada += duracion;
    }

    public void registrarProcesoCompletado(long tiempoLlegada, long tiempoInicio) {
        procesosCompletados++;
        sumaTiemposRespuesta += (tiempoInicio - tiempoLlegada);
    }

    public void registrarTiempoSimulado(long tiempo) {
        tiempoTotalSimulado = tiempo;
    }

    public void registrarTiempoPorProceso(int index, int tiempo) {
        if (index >= 0 && index < tiemposPorProceso.length) {
            tiemposPorProceso[index] = tiempo;
        }
    }

    public double calcularThroughput() {
        return (double) procesosCompletados / (tiempoTotalSimulado / 1000.0); // por segundo
    }

    public double calcularUtilizacionCPU(long tiempocpu) {
        return ((double) tiempocpu / tiempoTotalSimulado) * 100;
    }

    public double calcularTiempoRespuestaPromedio() {
        return procesosCompletados == 0 ? 0 : (double) sumaTiemposRespuesta / procesosCompletados;
    }

    public double calcularEquidad() {
        double promedio = Arrays.stream(tiemposPorProceso).average().orElse(0);
        double sumaDesviaciones = 0;
        for (int t : tiemposPorProceso) {
            sumaDesviaciones += Math.pow(t - promedio, 2);
        }
        return Math.sqrt(sumaDesviaciones / tiemposPorProceso.length); // desviación estándar
    }
}

