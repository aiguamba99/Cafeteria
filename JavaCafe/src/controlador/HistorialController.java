package controlador;

import vista.HistorialView;
import modelo.FileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Orden;
import vista.CocinaView;

public class HistorialController {
    private HistorialView view;
    private List<Orden> ordenesPendientes;

    public HistorialController(HistorialView view, List<Orden> ordenesPendientes) {
        this.view = view;
        this.ordenesPendientes = ordenesPendientes;
        this.view.setRegresarButtonListener(new RegresarButtonListener());
        this.view.setEliminarHistorialButtonListener(new EliminarHistorialButtonListener()); // Configurar el botón de eliminar historial
    }

    class RegresarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new CocinaController(new CocinaView(ordenesPendientes), ordenesPendientes);
        }
    }

    class EliminarHistorialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Eliminar el archivo de historial
            FileManager.eliminarHistorial();

            // Recargar el historial (que ahora estará vacío)
            view.cargarHistorial();

            // Mostrar un mensaje de confirmación
            JOptionPane.showMessageDialog(null, "El historial ha sido eliminado correctamente.");
        }
    }
}