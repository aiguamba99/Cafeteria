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

    // Listas de checkboxes para cada categoría
    private JCheckBox[] cafesCheckBoxes;
    private JCheckBox[] tesCheckBoxes;
    private JCheckBox[] postresCheckBoxes;
    private JCheckBox[] bebidasFriasCheckBoxes;

    public MenuView() {
        frame = new JFrame("Menú - Cafetería");
        frame.setSize(600, 500); // Aumentamos el tamaño para más espacio
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel principal con un layout de BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen alrededor del panel
        panel.setBackground(new Color(245, 245, 220)); // Color de fondo beige claro

        // Configurar la fuente elegante
        Font fuenteElegante = new Font("SansSerif", Font.BOLD, 14);

        // ComboBox para seleccionar el número de mesa (1 a 7)
        mesaComboBox = new JComboBox<>();
        for (int i = 1; i <= 7; i++) {
            mesaComboBox.addItem(i);
        }
        mesaComboBox.setFont(fuenteElegante);
        mesaComboBox.setBackground(Color.WHITE);

        // Panel para el ComboBox
        JPanel mesaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mesaPanel.setBackground(new Color(245, 245, 220)); // Fondo beige claro
        mesaPanel.add(new JLabel("Número de Mesa:"));
        mesaPanel.add(mesaComboBox);

        // Panel para las categorías del menú
        JPanel categoriasPanel = new JPanel();
        categoriasPanel.setLayout(new BoxLayout(categoriasPanel, BoxLayout.Y_AXIS));
        categoriasPanel.setBackground(new Color(245, 245, 220)); // Fondo beige claro

        // Cafés
        JPanel cafesPanel = crearCategoriaPanel("Cafés", new String[]{
            "Café Americano - $2.50",
            "Café Latte - $3.00",
            "Cappuccino - $3.50",
            "Espresso - $2.00"
        }, fuenteElegante);
        categoriasPanel.add(cafesPanel);

        // Tés
        JPanel tesPanel = crearCategoriaPanel("Tés", new String[]{
            "Té Verde - $1.50",
            "Té Negro - $1.50",
            "Té de Manzanilla - $1.75",
            "Té de Menta - $1.75"
        }, fuenteElegante);
        categoriasPanel.add(tesPanel);

        // Postres
        JPanel postresPanel = crearCategoriaPanel("Postres", new String[]{
            "Tarta de Queso - $4.00",
            "Brownie - $3.50",
            "Muffin de Chocolate - $2.50",
            "Galletas - $2.00"
        }, fuenteElegante);
        categoriasPanel.add(postresPanel);

        // Bebidas Frías
        JPanel bebidasFriasPanel = crearCategoriaPanel("Bebidas Frías", new String[]{
            "Smoothie de Frutas - $4.50",
            "Limonada - $3.00",
            "Té Helado - $2.50",
            "Café Frío - $3.50"
        }, fuenteElegante);
        categoriasPanel.add(bebidasFriasPanel);

        // ScrollPane para las categorías
        JScrollPane scrollPane = new JScrollPane(categoriasPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Sin borde

        // Panel para los botones
        JPanel botonesPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        botonesPanel.setBackground(new Color(245, 245, 220)); // Fondo beige claro

        // Botón de Regresar
        regresarButton = crearBoton("Regresar", fuenteElegante);
        botonesPanel.add(regresarButton);

        // Botón de Confirmar Pedido
        confirmarButton = crearBoton("Confirmar Pedido", fuenteElegante);
        botonesPanel.add(confirmarButton);

        // Agregar componentes al panel principal
        panel.add(mesaPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);

        itemsSeleccionados = new ArrayList<>();
    }

    private JPanel crearCategoriaPanel(String titulo, String[] items, Font fuente) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 220)); // Fondo beige claro
        panel.setBorder(BorderFactory.createTitledBorder(titulo)); // Título de la categoría

        for (String item : items) {
            JCheckBox checkBox = new JCheckBox(item);
            checkBox.setFont(fuente);
            checkBox.setBackground(new Color(245, 245, 220)); // Fondo beige claro
            checkBox.setFocusPainted(false); // Quitar el borde de enfoque
            panel.add(checkBox);
        }

        return panel;
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(new Color(139, 69, 19)); // Color marrón café
        boton.setForeground(Color.WHITE); // Texto en blanco
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        return boton;
    }

    public void setRegresarButtonListener(ActionListener listener) {
        regresarButton.addActionListener(listener);
    }

    public void setConfirmarButtonListener(ActionListener listener) {
        confirmarButton.addActionListener(listener);
    }

    public int getNumeroMesa() {
        return (int) mesaComboBox.getSelectedItem(); // Obtener el número de mesa seleccionado
    }

    public List<Item> getItemsSeleccionados() {
        itemsSeleccionados.clear(); // Limpiar la lista antes de agregar nuevos ítems

        // Obtener los ítems seleccionados de todas las categorías
        obtenerItemsSeleccionados(cafesCheckBoxes);
        obtenerItemsSeleccionados(tesCheckBoxes);
        obtenerItemsSeleccionados(postresCheckBoxes);
        obtenerItemsSeleccionados(bebidasFriasCheckBoxes);

        return itemsSeleccionados;
    }

    private void obtenerItemsSeleccionados(JCheckBox[] checkBoxes) {
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                String itemStr = checkBox.getText();
                String nombre = itemStr.split(" - ")[0]; // Obtener el nombre del ítem
                double precio = Double.parseDouble(itemStr.split("\\$")[1]); // Obtener el precio
                itemsSeleccionados.add(new Item(nombre, precio));
            }
        }
    }

    public void cerrar() {
        frame.dispose();
    }
}