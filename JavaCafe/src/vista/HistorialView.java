package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistorialView {
    private JFrame frame;
    private JButton regresarButton;
    private JButton eliminarHistorialButton;
    private JList<String> historialList;
    private DefaultListModel<String> historialModel;

    public HistorialView() {
        frame = new JFrame("Historial - Cafetería");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con un layout de cuadrícula
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen alrededor del panel
        panel.setBackground(new Color(245, 245, 220)); // Color de fondo beige claro

        // Configurar la fuente elegante
        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 14);

        // Modelo y lista para el historial
        historialModel = new DefaultListModel<>();
        historialList = new JList<>(historialModel);
        historialList.setFont(fuenteElegante);
        historialList.setBackground(new Color(245, 245, 220)); // Fondo beige claro
        JScrollPane scrollPane = new JScrollPane(historialList);

        // Panel para los botones
        JPanel botonesPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        botonesPanel.setBackground(new Color(245, 245, 220)); // Fondo beige claro

        // Botón de Regresar
        regresarButton = crearBoton("Regresar", fuenteElegante);
        botonesPanel.add(regresarButton);

        // Botón de Eliminar Historial
        eliminarHistorialButton = crearBoton("Eliminar Historial", fuenteElegante);
        botonesPanel.add(eliminarHistorialButton);

        // Cargar y mostrar el historial desde el archivo
        cargarHistorial();

        // Agregar componentes al panel principal
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(new Color(139, 69, 19)); // Color marrón café
        boton.setForeground(Color.WHITE); // Texto en blanco
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        return boton;
    }

    public void cargarHistorial() {
        historialModel.clear(); // Limpiar el modelo antes de cargar el historial
        try (BufferedReader reader = new BufferedReader(new FileReader("historial.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                historialModel.addElement(linea); // Agregar cada línea al modelo
            }
        } catch (IOException e) {
            historialModel.addElement("No se pudo cargar el historial.");
        }
    }

    public void setRegresarButtonListener(ActionListener listener) {
        regresarButton.addActionListener(listener);
    }

    public void setEliminarHistorialButtonListener(ActionListener listener) {
        eliminarHistorialButton.addActionListener(listener);
    }

    public void cerrar() {
        frame.dispose();
    }
}