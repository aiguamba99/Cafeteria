package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Item;
import modelo.Orden;

public class CocinaView {
    private JFrame frame;
    private JButton regresarButton;
    private JButton marcarListoButton;
    private JButton verHistorialButton;
    private JTextArea ordenesTextArea;

    public CocinaView(List<Orden> ordenesPendientes) {
        frame = new JFrame("Cocina - Cafetería");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con un layout de BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen alrededor del panel
        panel.setBackground(new Color(245, 245, 220)); // Color de fondo beige claro

        // Configurar la fuente elegante
        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 14);

        // Área de texto para mostrar las órdenes
        ordenesTextArea = new JTextArea();
        ordenesTextArea.setFont(fuenteElegante);
        ordenesTextArea.setBackground(new Color(245, 245, 220)); // Fondo beige claro
        ordenesTextArea.setEditable(false); // No editable
        ordenesTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        // Mostrar las órdenes pendientes
        mostrarOrdenes(ordenesPendientes);

        JScrollPane scrollPane = new JScrollPane(ordenesTextArea);

        // Panel para los botones
        JPanel botonesPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        botonesPanel.setBackground(new Color(245, 245, 220)); // Fondo beige claro

        // Botón de Regresar
        regresarButton = crearBoton("Regresar", fuenteElegante);
        botonesPanel.add(regresarButton);

        // Botón de Marcar como Listo
        marcarListoButton = crearBoton("Marcar como Listo", fuenteElegante);
        botonesPanel.add(marcarListoButton);

        // Botón de Ver Historial
        verHistorialButton = crearBoton("Ver Historial", fuenteElegante);
        botonesPanel.add(verHistorialButton);

        // Agregar componentes al panel principal
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private void mostrarOrdenes(List<Orden> ordenesPendientes) {
        StringBuilder ordenesStr = new StringBuilder();
        for (Orden orden : ordenesPendientes) {
            ordenesStr.append("Mesa ").append(orden.getNumeroMesa()).append(":\n");
            for (Item item : orden.getItems()) {
                ordenesStr.append("  - ").append(item.getNombre()).append(" ($").append(item.getPrecio()).append(")\n");
            }
            ordenesStr.append("Total: $").append(orden.getPrecioTotal()).append("\n");
            ordenesStr.append("----------------------------------------\n"); // Línea divisoria
        }
        ordenesTextArea.setText(ordenesStr.toString());
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(new Color(139, 69, 19)); // Color marrón café
        boton.setForeground(Color.WHITE); // Texto en blanco
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        return boton;
    }

    public void setRegresarButtonListener(ActionListener listener) {
        regresarButton.addActionListener(listener);
    }

    public void setMarcarListoButtonListener(ActionListener listener) {
        marcarListoButton.addActionListener(listener);
    }

    public void setVerHistorialButtonListener(ActionListener listener) {
        verHistorialButton.addActionListener(listener);
    }

    public void cerrar() {
        frame.dispose();
    }
}