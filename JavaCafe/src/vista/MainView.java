package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView {
    private JFrame frame;
    private JButton menuButton;
    private JButton cocinaButton;
    private JButton historialButton;

    public MainView() {
        frame = new JFrame("Cafetería - Inicio");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con un layout de cuadrícula (3 filas, 1 columna)
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen alrededor del panel
        panel.setBackground(new Color(245, 245, 220)); // Color de fondo beige claro

        // Configurar la fuente elegante
        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 16);

        // Botón de Menú
        menuButton = new JButton("Menú");
        menuButton.setFont(fuenteElegante);
        menuButton.setBackground(new Color(139, 69, 19)); // Color marrón café
        menuButton.setForeground(Color.WHITE); // Texto en blanco
        menuButton.setFocusPainted(false); // Quitar el borde de enfoque
        panel.add(menuButton);

        // Botón de Cocina
        cocinaButton = new JButton("Cocina");
        cocinaButton.setFont(fuenteElegante);
        cocinaButton.setBackground(new Color(139, 69, 19)); // Color marrón café
        cocinaButton.setForeground(Color.WHITE); // Texto en blanco
        cocinaButton.setFocusPainted(false); // Quitar el borde de enfoque
        panel.add(cocinaButton);

        // Botón de Historial
        historialButton = new JButton("Historial");
        historialButton.setFont(fuenteElegante);
        historialButton.setBackground(new Color(139, 69, 19)); // Color marrón café
        historialButton.setForeground(Color.WHITE); // Texto en blanco
        historialButton.setFocusPainted(false); // Quitar el borde de enfoque
        panel.add(historialButton);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }

    public void setMenuButtonListener(ActionListener listener) {
        menuButton.addActionListener(listener);
    }

    public void setCocinaButtonListener(ActionListener listener) {
        cocinaButton.addActionListener(listener);
    }

    public void setHistorialButtonListener(ActionListener listener) {
        historialButton.addActionListener(listener);
    }

    public void cerrar() {
        frame.dispose();
    }
}