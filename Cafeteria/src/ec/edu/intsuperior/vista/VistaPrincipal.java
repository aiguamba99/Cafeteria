package ec.edu.intsuperior.vista;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {
    private JButton btnMenu, btnCocina;

    public VistaPrincipal() {
        setTitle("Sistema de Pedidos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        btnMenu = new JButton("Menú");
        btnCocina = new JButton("Cocina");

        add(btnMenu);
        add(btnCocina);
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getBtnCocina() {
        return btnCocina;
    }
}



