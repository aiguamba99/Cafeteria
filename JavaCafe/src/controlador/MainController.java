package controlador;

import vista.MainView;
import vista.CocinaView;
import vista.HistorialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.Orden;
import vista.MenuView;

public class MainController {
    private MainView view;
    public static List<Orden> ordenesPendientes = new ArrayList<>(); // Lista global de órdenes pendientes

    public MainController(MainView view) {
        this.view = view;
        this.view.setMenuButtonListener(new MenuButtonListener());
        this.view.setCocinaButtonListener(new CocinaButtonListener());
        this.view.setHistorialButtonListener(new HistorialButtonListener()); // Configurar el botón de historial
    }

    class MenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new MenuController(new MenuView());
        }
    }

    class CocinaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new CocinaController(new CocinaView(ordenesPendientes), ordenesPendientes);
        }
    }

    class HistorialButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new HistorialController(new HistorialView(), ordenesPendientes); // Abrir el historial
        }
    }
}
