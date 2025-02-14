package ec.edu.intsuperior.vista;

import javax.swing.*;
import java.awt.*;

public class VistaPedidos extends JFrame {
    private JComboBox<String> comboMesas;
    private JTable tablaProductos;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JTable tablaPedido;
    private JLabel lblSubtotal;
    private JButton btnConfirmar, btnEditar, btnCancelar;

    public VistaPedidos() {
        setTitle("Registro de Pedidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel para seleccionar mesa
        JPanel panelMesa = new JPanel();
        panelMesa.add(new JLabel("Mesa:"));
        comboMesas = new JComboBox<>(new String[]{"Mesa 1", "Mesa 2", "Mesa 3"});
        panelMesa.add(comboMesas);
        panelPrincipal.add(panelMesa, BorderLayout.NORTH);

        // Panel para productos disponibles
        JPanel panelProductos = new JPanel(new BorderLayout());
        panelProductos.add(new JLabel("Productos Disponibles:"), BorderLayout.NORTH);
        tablaProductos = new JTable(new Object[][]{{"Café", "1.50"}, {"Té", "1.00"}}, new String[]{"Producto", "Precio"});
        panelProductos.add(new JScrollPane(tablaProductos), BorderLayout.CENTER);

        // Panel para agregar productos al pedido
        JPanel panelAgregar = new JPanel();
        panelAgregar.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField(5);
        panelAgregar.add(txtCantidad);
        btnAgregar = new JButton("Agregar");
        panelAgregar.add(btnAgregar);
        panelProductos.add(panelAgregar, BorderLayout.SOUTH);

        panelPrincipal.add(panelProductos, BorderLayout.WEST);

        // Panel para el pedido actual
        JPanel panelPedido = new JPanel(new BorderLayout());
        panelPedido.add(new JLabel("Pedido Actual:"), BorderLayout.NORTH);
        tablaPedido = new JTable(new Object[][]{}, new String[]{"Producto", "Cantidad", "Precio"});
        panelPedido.add(new JScrollPane(tablaPedido), BorderLayout.CENTER);

        // Panel para subtotal y botones
        JPanel panelSubtotal = new JPanel();
        lblSubtotal = new JLabel("Subtotal: $0.00");
        panelSubtotal.add(lblSubtotal);
        btnConfirmar = new JButton("Confirmar");
        btnEditar = new JButton("Editar");
        btnCancelar = new JButton("Cancelar");
        panelSubtotal.add(btnConfirmar);
        panelSubtotal.add(btnEditar);
        panelSubtotal.add(btnCancelar);
        panelPedido.add(panelSubtotal, BorderLayout.SOUTH);

        panelPrincipal.add(panelPedido, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaPedidos().setVisible(true);
        });
    }
}
