package algoritmo;

import interfaz.VentanaPrincipalPrincipal;
import logic.Proceso;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;

public class SJF {
    private List<Proceso> procesosOrdenados;
    private VentanaPrincipalPrincipal ventana;

    public SJF(VentanaPrincipalPrincipal ventana) {
        this.ventana = ventana;
    }

    public void planificar(List<Proceso> procesos) {
        new SJFWorker(procesos).execute();
    }

    private class SJFWorker extends SwingWorker<Void, Proceso> {
        private List<Proceso> procesos;

        public SJFWorker(List<Proceso> procesos) {
            this.procesos = procesos;
            procesosOrdenados = new ArrayList<>(procesos);
            Collections.sort(procesosOrdenados, (p1, p2) -> Integer.compare(p1.getTiempoRafaga(), p2.getTiempoRafaga()));
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (Proceso proceso : procesosOrdenados) {
                publish(proceso); // Publica el proceso para actualizar la GUI
                Thread.sleep(1000); // Simulación de tiempo de ejecución de procesos
            }
            return null;
        }

        @Override
        protected void process(List<Proceso> chunks) {
            for (Proceso proceso : chunks) {
                actualizarGrafica(proceso);
            }
        }
    }

    private void actualizarGrafica(Proceso proceso) {
        SwingUtilities.invokeLater(() -> {
            ventana.actualizarBarraDeProgreso(proceso);
        });
    }
}
