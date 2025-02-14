package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Venta;
import ec.edu.intsuperior.vista.VistaHistorialVentas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorVentas {
    private VistaHistorialVentas vistaHistorialVentas;
    private List<Venta> ventas;

    // Constructor
    public ControladorVentas(VistaHistorialVentas vistaHistorialVentas, List<Venta> ventas) {
        this.vistaHistorialVentas = vistaHistorialVentas;
        this.ventas = ventas;
        inicializarEventos();
        cargarVentas();
    }

    // Inicializa eventos de la vista
    private void inicializarEventos() {
        vistaHistorialVentas.getBtnFiltrar().addActionListener(e -> filtrarVentas());
    }

    // Carga las ventas en la tabla
    private void cargarVentas() {
        DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();
        modeloTabla.setRowCount(0);
        for (Venta venta : ventas) {
            Object[] fila = {venta.getId(), venta.getFecha(), venta.getTotal()};
            modeloTabla.addRow(fila);
        }
        calcularTotalIngresos();
    }

    // Filtra las ventas por fecha
    private void filtrarVentas() {
        String fechaFiltro = vistaHistorialVentas.getTxtFecha().getText().trim();
        if (!fechaFiltro.isEmpty()) {
            DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();
            modeloTabla.setRowCount(0);
            for (Venta venta : ventas) {
                // Se compara la fecha convertida a String
                if (venta.getFecha().toString().equals(fechaFiltro)) {
                    Object[] fila = {venta.getId(), venta.getFecha(), venta.getTotal()};
                    modeloTabla.addRow(fila);
                }
            }
            calcularTotalIngresos();
        } else {
            JOptionPane.showMessageDialog(vistaHistorialVentas, "Ingrese una fecha para filtrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Calcula y muestra el total de ingresos
    private void calcularTotalIngresos() {
        double totalIngresos = 0.0;
        DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            Object value = modeloTabla.getValueAt(i, 2);
            double total;
            if (value instanceof Number) {
                total = ((Number) value).doubleValue();
            } else {
                try {
                    total = Double.parseDouble(value.toString());
                } catch (NumberFormatException e) {
                    total = 0.0;
                }
            }
            totalIngresos += total;
        }
        vistaHistorialVentas.getLblTotal().setText("Total de ingresos: $" + totalIngresos);
    }
}

