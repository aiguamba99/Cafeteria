package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.Item;

public class MenuView {
    private JFrame frame;
    private JButton regresarButton;
    private JButton confirmarButton;
    private JComboBox<Integer> mesaComboBox;
    private List<Item> itemsSeleccionados;

    private JCheckBox[] checkboxes;
    private String[][] categorias = {
        {"Cafés", "Café Americano - $2.50", "Café Latte - $3.00", "Cappuccino - $3.50", "Espresso - $2.00"},
        {"Tés", "Té Verde - $1.50", "Té Negro - $1.50", "Té de Manzanilla - $1.75", "Té de Menta - $1.75"},
        {"Postres", "Tarta de Queso - $4.00", "Brownie - $3.50", "Muffin de Chocolate - $2.50", "Galletas - $2.00"},
        {"Bebidas Frías", "Smoothie de Frutas - $4.50", "Limonada - $3.00", "Té Helado - $2.50", "Café Frío - $3.50"}
    };

    public MenuView() {
        frame = new JFrame("Menú - Cafetería");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(245, 245, 220));

        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 14);

        mesaComboBox = new JComboBox<>();
        for (int i = 1; i <= 7; i++) {
            mesaComboBox.addItem(i);
        }
        mesaComboBox.setFont(fuenteElegante);
        mesaComboBox.setBackground(Color.WHITE);
        panel.add(new JLabel("Número de Mesa:"));
        panel.add(mesaComboBox);

        List<JCheckBox> checkboxList = new ArrayList<>();
        for (String[] categoria : categorias) {
            panel.add(new JLabel(categoria[0] + ":"));
            for (int i = 1; i < categoria.length; i++) {
                JCheckBox checkbox = crearCheckbox(categoria[i], fuenteElegante);
                panel.add(checkbox);
                checkboxList.add(checkbox);
            }
        }
        checkboxes = checkboxList.toArray(new JCheckBox[0]);

        regresarButton = crearBoton("Regresar", fuenteElegante);
        confirmarButton = crearBoton("Confirmar Pedido", fuenteElegante);
        panel.add(confirmarButton);
        panel.add(regresarButton);

        itemsSeleccionados = new ArrayList<>();
        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }

    private JCheckBox crearCheckbox(String texto, Font fuente) {
        JCheckBox checkbox = new JCheckBox(texto);
        checkbox.setFont(fuente);
        checkbox.setBackground(new Color(245, 245, 220));
        checkbox.setFocusPainted(false);
        return checkbox;
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(new Color(139, 69, 19));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }

    public void setRegresarButtonListener(ActionListener listener) {
        regresarButton.addActionListener(listener);
    }

    public void setConfirmarButtonListener(ActionListener listener) {
        confirmarButton.addActionListener(listener);
    }

    public int getNumeroMesa() {
        return (int) mesaComboBox.getSelectedItem();
    }

    public List<Item> getItemsSeleccionados() {
        itemsSeleccionados.clear();
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                String[] partes = checkbox.getText().split(" - ");
                itemsSeleccionados.add(new Item(partes[0], Double.parseDouble(partes[1].substring(1))));
            }
        }
        return itemsSeleccionados;
    }

    public void cerrar() {
        frame.dispose();
    }
}