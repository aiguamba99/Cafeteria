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
    private JList<String> ordenesPendientesList;
    private DefaultListModel<String> ordenesPendientesModel;

    public CocinaView(List<Orden> ordenesPendientes) {
        frame = new JFrame("Cocina - Cafetería");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con un layout de BorderLayout y margen externo
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 220)); // Beige claro

        // Fuente elegante
        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 14);

        // Lista de órdenes pendientes
        ordenesPendientesModel = new DefaultListModel<>();
        for (Orden orden : ordenesPendientes) {
            ordenesPendientesModel.addElement(formatearOrden(orden));
        }

        ordenesPendientesList = new JList<>(ordenesPendientesModel);
        ordenesPendientesList.setFont(fuenteElegante);
        ordenesPendientesList.setBackground(new Color(245, 245, 220));

        JScrollPane scrollPane = new JScrollPane(ordenesPendientesList);

        // Panel para los botones
        JPanel botonesPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        botonesPanel.setBackground(new Color(245, 245, 220));

        // Crear y agregar botones al panel
        regresarButton = crearBoton("Regresar", fuenteElegante);
        marcarListoButton = crearBoton("Marcar como Listo", fuenteElegante);
        verHistorialButton = crearBoton("Ver Historial", fuenteElegante);

        botonesPanel.add(regresarButton);
        botonesPanel.add(marcarListoButton);
        botonesPanel.add(verHistorialButton);

        // Agregar componentes al panel principal
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame y mostrarlo
        frame.add(panel);
        frame.setVisible(true);
    }

    private String formatearOrden(Orden orden) {
        StringBuilder ordenInfo = new StringBuilder();
        ordenInfo.append("Mesa ").append(orden.getNumeroMesa()).append("\n");

        for (Item item : orden.getItems()) {
            ordenInfo.append("- ").append(item.getNombre()).append(" ($")
                    .append(item.getPrecio()).append(")\n");
        }

        ordenInfo.append("Total: $").append(orden.getPrecioTotal()).append("\n");
        return ordenInfo.toString();
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(new Color(139, 69, 19)); // Marrón café
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
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

    public int getOrdenSeleccionadaIndex() {
        return ordenesPendientesList.getSelectedIndex();
    }

    public void cerrar() {
        frame.dispose();
    }
}
