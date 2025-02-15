package ec.edu.intsuperior.vista;

import ec.edu.intsuperior.controlador.ControladorMenu;
import ec.edu.intsuperior.modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenu extends JFrame {

    private ControladorMenu controlador;
    private JTextArea textAreaPedido;

    public VistaMenu(ControladorMenu controlador) {
        this.controlador = controlador;

        // Configuración de la ventana
        setTitle("Menú");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Crear los componentes de la vista
        textAreaPedido = new JTextArea();
        textAreaPedido.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaPedido);

        JButton btnAgregarCafe = new JButton("Agregar Café");
        JButton btnAgregarPostre = new JButton("Agregar Postre");
        JButton btnVolver = new JButton("Volver");

        // Panel para botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregarCafe);
        panelBotones.add(btnAgregarPostre);
        panelBotones.add(btnVolver);

        // Agregar todo al layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Acciones de los botones
        btnAgregarCafe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto cafe = new Producto("Café", 2.5);
                controlador.agregarProducto(cafe);
                actualizarListaPedido();
            }
        });

        btnAgregarPostre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto postre = new Producto("Postre", 3.0);
                controlador.agregarProducto(postre);
                actualizarListaPedido();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver a la ventana principal o cerrar esta ventana
                dispose(); // Cierra la ventana actual
            }
        });
    }

    public void actualizarListaPedido() {
        StringBuilder pedidoText = new StringBuilder("Pedido Actual:\n");
        for (Producto producto : controlador.getPedido().getProductos()) {
            pedidoText.append(producto.getNombre()).append(" - $").append(producto.getPrecio()).append("\n");
        }
        pedidoText.append("Total: $").append(controlador.getPedido().calcularTotal());
        textAreaPedido.setText(pedidoText.toString());
    }
}






