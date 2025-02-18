package controlador;

import vista.CocinaView;
import vista.HistorialView;
import modelo.Orden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.FileManager;
import vista.MainView;

public class CocinaController {
    private CocinaView view;
    private List<Orden> ordenesPendientes;

    public CocinaController(CocinaView view, List<Orden> ordenesPendientes) {
        this.view = view;
        this.ordenesPendientes = ordenesPendientes;
        this.view.setRegresarButtonListener(new RegresarButtonListener());
        this.view.setMarcarListoButtonListener(new MarcarListoButtonListener());
        this.view.setVerHistorialButtonListener(new VerHistorialButtonListener());
    }

    class RegresarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new MainController(new MainView());
        }
    }

    class MarcarListoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getOrdenSeleccionadaIndex();
            if (selectedIndex != -1) {
                // Marcar la orden como completada
                Orden orden = ordenesPendientes.get(selectedIndex);
                orden.setEstado("completada");

                // Guardar la orden en el historial
                FileManager.guardarHistorial(orden);

                // Eliminar la orden de la lista de pendientes
                ordenesPendientes.remove(selectedIndex);
                view.cerrar();
                new CocinaController(new CocinaView(ordenesPendientes), ordenesPendientes);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una orden para marcarla como lista.");
            }
        }
    }

    class VerHistorialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new HistorialController(new HistorialView(), ordenesPendientes); // Pasar la lista de órdenes
        }
    }
}
