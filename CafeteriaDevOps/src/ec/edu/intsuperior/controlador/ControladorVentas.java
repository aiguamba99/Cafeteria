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
        cargarVentas(); // Cargar ventas al iniciar
    }

    // Inicializar eventos de la vista
    private void inicializarEventos() {
        vistaHistorialVentas.getBtnFiltrar().addActionListener(e -> filtrarVentas());
    }

    // Método para cargar las ventas en la tabla
    private void cargarVentas() {
        DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (Venta venta : ventas) {
            Object[] fila = {
                venta.getId(),
                venta.getFecha(),
                venta.getTotal()
            };
            modeloTabla.addRow(fila);
        }

        calcularTotalIngresos(); // Calcular el total de ingresos
    }

    // Método para filtrar ventas por fecha
    private void filtrarVentas() {
        String fechaFiltro = vistaHistorialVentas.getTxtFecha().getText().trim();
        if (!fechaFiltro.isEmpty()) {
            DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();
            modeloTabla.setRowCount(0); // Limpiar la tabla

            for (Venta venta : ventas) {
                if (venta.getFecha().toString().equals(fechaFiltro)) {
                    Object[] fila = {
                        venta.getId(),
                        venta.getFecha(),
                        venta.getTotal()
                    };
                    modeloTabla.addRow(fila);
                }
            }

            calcularTotalIngresos(); // Calcular el total de ingresos filtrados
        } else {
            JOptionPane.showMessageDialog(vistaHistorialVentas, "Ingrese una fecha para filtrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para calcular el total de ingresos
    private void calcularTotalIngresos() {
        double totalIngresos = 0.0;
        DefaultTableModel modeloTabla = vistaHistorialVentas.getModeloTablaVentas();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            totalIngresos += (double) modeloTabla.getValueAt(i, 2); // Sumar los totales de las ventas
        }

        vistaHistorialVentas.getLblTotal().setText("Total de ingresos: $" + totalIngresos);
    }
}
