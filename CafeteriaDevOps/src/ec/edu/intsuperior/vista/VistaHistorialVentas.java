package ec.edu.intsuperior.vista;

import javax.swing.*;
import java.awt.*;

public class VistaHistorialVentas extends JFrame {
    private JTable tablaVentas;
    private JTextField txtFecha;
    private JButton btnFiltrar;
    private JLabel lblTotal;

    public VistaHistorialVentas() {
        setTitle("Historial de Ventas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel de filtrado por fecha
        JPanel panelFiltro = new JPanel();
        panelFiltro.add(new JLabel("Filtrar por fecha:"));
        txtFecha = new JTextField(10);
        panelFiltro.add(txtFecha);
        btnFiltrar = new JButton("Filtrar");
        panelFiltro.add(btnFiltrar);
        panelPrincipal.add(panelFiltro, BorderLayout.NORTH);

        // Tabla de ventas
        tablaVentas = new JTable(new Object[][]{
                {"2023-10-01", "150.00"},
                {"2023-10-02", "200.00"}
        }, new String[]{"Fecha", "Total"});
        panelPrincipal.add(new JScrollPane(tablaVentas), BorderLayout.CENTER);

        // Panel para mostrar el total de ingresos
        JPanel panelTotal = new JPanel();
        lblTotal = new JLabel("Total de ingresos: $0.00");
        panelTotal.add(lblTotal);
        panelPrincipal.add(panelTotal, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaHistorialVentas().setVisible(true);
        });
    }
}