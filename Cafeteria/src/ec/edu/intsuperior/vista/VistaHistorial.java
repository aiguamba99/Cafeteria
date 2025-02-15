package ec.edu.intsuperior.vista;

import ec.edu.intsuperior.modelo.HistorialPedidos;
import ec.edu.intsuperior.modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VistaHistorial extends JFrame {
    private JTextArea historialArea;

    public VistaHistorial() {
        setTitle("Historial de Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        historialArea = new JTextArea();
        add(new JScrollPane(historialArea), BorderLayout.CENTER);
        actualizarHistorial();
    }

    public void actualizarHistorial() {
        StringBuilder sb = new StringBuilder();
        for (Pedido p : HistorialPedidos.getHistorial()) {
            sb.append(p.toString()).append("\n");
        }
        historialArea.setText(sb.toString());
    }
}

