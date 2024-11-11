package algoritmo;

import interfaz.VentanaPrincipalPrincipal;
import logic.Proceso;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;

public class FCFS {
    private int tiempoActual = 0;
    private List<Proceso> procesosOrdenados;
    private VentanaPrincipalPrincipal ventana;

    // Constructor que recibe una referencia a la ventana principal
    public FCFS(VentanaPrincipalPrincipal ventana) {
        this.ventana = ventana;
    }

    public void planificar(List<Proceso> procesos) {
        new FCFSWorker(procesos).execute();
    }

    private class FCFSWorker extends SwingWorker<Void, Proceso> {
        private List<Proceso> procesos;

        public FCFSWorker(List<Proceso> procesos) {
            this.procesos = procesos;
            procesosOrdenados = new ArrayList<>();
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (Proceso proceso : procesos) {
                if (tiempoActual < proceso.getTiempoLlegada()) {
                    tiempoActual = proceso.getTiempoLlegada();
                }
                proceso.setTiempoInicio(tiempoActual);
                proceso.setTiempoFinalizacion(tiempoActual + proceso.getTiempoRafaga());
                tiempoActual += proceso.getTiempoRafaga();

                publish(proceso); // Publica el proceso para actualizar la GUI
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
