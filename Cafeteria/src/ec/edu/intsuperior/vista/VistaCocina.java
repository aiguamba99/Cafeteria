package ec.edu.intsuperior.vista;

import ec.edu.intsuperior.controlador.ControladorCocina;
import ec.edu.intsuperior.modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VistaCocina extends JFrame {
    private DefaultListModel<String> modeloLista;
    private JList<String> listaPedidos;
    private JButton btnOrdenLista, btnCancelar;

    private ControladorCocina controlador;

    public VistaCocina(ControladorCocina controlador) {
        this.controlador = controlador;
        setTitle("Cocina");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        listaPedidos = new JList<>(modeloLista);
        add(new JScrollPane(listaPedidos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnOrdenLista = new JButton("Orden Lista");
        btnCancelar = new JButton("Cancelar Pedido");

        btnOrdenLista.addActionListener(e -> marcarOrdenLista());
        btnCancelar.addActionListener(e -> cancelarPedido());

        panelBotones.add(btnOrdenLista);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void recibirPedido(Pedido pedido) {
        modeloLista.addElement("Pedido recibido");
    }

    private void marcarOrdenLista() {
        int index = listaPedidos.getSelectedIndex();
        if (index != -1) {
            modeloLista.remove(index);
        }
    }

    private void cancelarPedido() {
        int index = listaPedidos.getSelectedIndex();
        if (index != -1) {
            modeloLista.remove(index);
        }
    }
}

