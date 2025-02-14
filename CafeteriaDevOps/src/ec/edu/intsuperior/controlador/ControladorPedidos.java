package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Pedido;
import ec.edu.intsuperior.modelo.Producto;
import ec.edu.intsuperior.vista.VistaPedidos;
import java.util.ArrayList;
import java.util.List;

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

    // Constructor alternativo para cargar productos desde la base de datos
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
        // Obtener el producto seleccionado y la cantidad
        Producto productoSeleccionado = obtenerProductoSeleccionado();
        if (productoSeleccionado != null) {
            try {
                int cantidad = Integer.parseInt(vistaPedidos.getTxtCantidad().getText());
                if (cantidad > 0) {
                    // Agregar el producto al pedido actual
                    pedidoActual.agregarProducto(productoSeleccionado, cantidad);

                    // Actualizar la vista
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

    // Método para obtener el producto seleccionado en la tabla
    private Producto obtenerProductoSeleccionado() {
        int filaSeleccionada = vistaPedidos.getTablaProductos().getSelectedRow();
        if (filaSeleccionada >= 0) {
            return productos.get(filaSeleccionada);
        }
        return null;
    }

    // Método para actualizar la tabla de pedidos en la vista
    private void actualizarTablaPedido() {
        // Limpiar la tabla
        vistaPedidos.getModeloTablaPedido().setRowCount(0);

        // Llenar la tabla con los productos del pedido actual
        for (Producto producto : pedidoActual.getProductos()) {
            Object[] fila = {producto.getNombre(), producto.getPrecio()};
            vistaPedidos.getModeloTablaPedido().addRow(fila);
        }
    }

    // Método para confirmar el pedido
    private void confirmarPedido() {
        if (!pedidoActual.getProductos().isEmpty()) {
            pedidos.add(pedidoActual);
            JOptionPane.showMessageDialog(vistaPedidos, "Pedido confirmado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            reiniciarPedido();
        } else {
            JOptionPane.showMessageDialog(vistaPedidos, "No hay productos en el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para reiniciar el pedido actual
    private void reiniciarPedido() {
        pedidoActual = new Pedido(0, 0, "Pendiente", 0.0);
        actualizarTablaPedido();
        vistaPedidos.getLblSubtotal().setText("Subtotal: $0.00");
    }

    // Método para editar el pedido
    private void editarPedido() {
        // Lógica para editar un pedido (puedes implementarla según tus necesidades)
    }

    // Método para cancelar el pedido
    private void cancelarPedido() {
        reiniciarPedido();
        JOptionPane.showMessageDialog(vistaPedidos, "Pedido cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}