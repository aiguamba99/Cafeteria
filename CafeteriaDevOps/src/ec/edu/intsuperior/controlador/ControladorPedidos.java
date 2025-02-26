package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Pedido;
import ec.edu.intsuperior.modelo.Producto;
import ec.edu.intsuperior.vista.VistaPedidos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorPedidos {
    private VistaPedidos vistaPedidos;
    private List<Producto> productos;
    private List<Pedido> pedidos;
    private Pedido pedidoActual; // Pedido en proceso

    // Constructor principal
    public ControladorPedidos(VistaPedidos vistaPedidos, List<Producto> productos, List<Pedido> pedidos) {
        this.vistaPedidos = vistaPedidos;
        this.productos = productos;
        this.pedidos = pedidos;
        this.pedidoActual = new Pedido(0, 0, "Pendiente", 0.0); // Inicializar un pedido vacío
        inicializarEventos();
    }

    // Constructor alternativo para cargar productos desde la BD
    public ControladorPedidos(VistaPedidos vistaPedidos) {
        this(vistaPedidos, Producto.obtenerProductosDesdeBD(), new ArrayList<>());
    }

    // Inicializar eventos de la vista
    private void inicializarEventos() {
        vistaPedidos.getBtnAgregar().addActionListener(e -> agregarProductoAlPedido());
        vistaPedidos.getBtnConfirmar().addActionListener(e -> confirmarPedido());
        vistaPedidos.getBtnEditar().addActionListener(e -> editarPedido());
        vistaPedidos.getBtnCancelar().addActionListener(e -> cancelarPedido());
    }

    // Método para agregar un producto al pedido actual
    private void agregarProductoAlPedido() {
        Producto productoSeleccionado = obtenerProductoSeleccionado();
        if (productoSeleccionado != null) {
            try {
                int cantidad = Integer.parseInt(vistaPedidos.getTxtCantidad().getText());
                if (cantidad > 0) {
                    pedidoActual.agregarProducto(productoSeleccionado, cantidad);
                    actualizarTablaPedido();
                    vistaPedidos.getLblSubtotal().setText("Subtotal: $" + pedidoActual.getSubtotal());
                } else {
                    JOptionPane.showMessageDialog(vistaPedidos, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(vistaPedidos, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vistaPedidos, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Obtiene el producto seleccionado en la tabla
    private Producto obtenerProductoSeleccionado() {
        int filaSeleccionada = vistaPedidos.getTablaProductos().getSelectedRow();
        if (filaSeleccionada >= 0) {
            return productos.get(filaSeleccionada);
        }
        return null;
    }

    // Actualiza la tabla de pedido en la vista
    private void actualizarTablaPedido() {
        vistaPedidos.getModeloTablaPedido().setRowCount(0);
        for (Producto producto : pedidoActual.getProductos()) {
            Object[] fila = {producto.getNombre(), producto.getPrecio()};
            vistaPedidos.getModeloTablaPedido().addRow(fila);
        }
    }

    // Confirma el pedido actual
    private void confirmarPedido() {
        if (!pedidoActual.getProductos().isEmpty()) {
            pedidos.add(pedidoActual);
            JOptionPane.showMessageDialog(vistaPedidos, "Pedido confirmado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            reiniciarPedido();
        } else {
            JOptionPane.showMessageDialog(vistaPedidos, "No hay productos en el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Reinicia el pedido actual
    private void reiniciarPedido() {
        pedidoActual = new Pedido(0, 0, "Pendiente", 0.0);
        actualizarTablaPedido();
        vistaPedidos.getLblSubtotal().setText("Subtotal: $0.00");
    }

    // Lógica para editar el pedido (a implementar según tus necesidades)
    private void editarPedido() {
        System.out.println("Editar pedido...");
    }

    // Cancela el pedido actual
    private void cancelarPedido() {
        reiniciarPedido();
        JOptionPane.showMessageDialog(vistaPedidos, "Pedido cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
