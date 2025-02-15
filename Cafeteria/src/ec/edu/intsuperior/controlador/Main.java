package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.vista.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            ControladorCocina controladorCocina = new ControladorCocina();
            VistaCocina vistaCocina = new VistaCocina(controladorCocina);

            // Crear el controlador de VistaMenu antes de crear VistaMenu
            ControladorMenu controladorMenu = new ControladorMenu();

            // Inicializar VistaMenu pasándole el controlador
            VistaMenu vistaMenu = new VistaMenu(controladorMenu);

            // Asignar el controlador a VistaMenu
            controladorMenu.setVistaMenu(vistaMenu);

            vistaPrincipal.getBtnMenu().addActionListener(e -> {
                vistaPrincipal.setVisible(false);
                vistaMenu.setVisible(true);
            });

            vistaPrincipal.getBtnCocina().addActionListener(e -> {
                vistaPrincipal.setVisible(false);
                vistaCocina.setVisible(true);
            });

            vistaPrincipal.setVisible(true);
        });
    }
}







