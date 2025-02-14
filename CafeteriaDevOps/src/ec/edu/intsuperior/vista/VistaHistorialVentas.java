package ec.edu.intsuperior.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaHistorialVentas extends JFrame {
    private JTable tablaVentas;
    private JTextField txtFecha;
    private JButton btnFiltrar;
    private JLabel lblTotal;
    private DefaultTableModel modeloTablaVentas;

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

        // Modelo y tabla de ventas con columnas: ID, Fecha, Total
        modeloTablaVentas = new DefaultTableModel(new String[]{"ID", "Fecha", "Total"}, 0);
        // Datos de ejemplo
        modeloTablaVentas.addRow(new Object[]{1, "2023-10-01", 150.00});
        modeloTablaVentas.addRow(new Object[]{2, "2023-10-02", 200.00});
        tablaVentas = new JTable(modeloTablaVentas);
        panelPrincipal.add(new JScrollPane(tablaVentas), BorderLayout.CENTER);

        // Panel para mostrar el total de ingresos
        JPanel panelTotal = new JPanel();
        lblTotal = new JLabel("Total de ingresos: $0.00");
        panelTotal.add(lblTotal);
        panelPrincipal.add(panelTotal, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // Getters para componentes
    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }
    public JTextField getTxtFecha() {
        return txtFecha;
    }
    public DefaultTableModel getModeloTablaVentas() {
        return modeloTablaVentas;
    }
    public JLabel getLblTotal() {
        return lblTotal;
    }
    public JTable getTablaVentas() {
        return tablaVentas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaHistorialVentas().setVisible(true);
        });
    }
}
