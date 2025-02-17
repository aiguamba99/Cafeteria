package controlador;

import vista.MenuView;
import modelo.Item;
import modelo.Orden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.CocinaView;
import vista.MainView;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        this.view.setRegresarButtonListener(new RegresarButtonListener());
        this.view.setConfirmarButtonListener(new ConfirmarButtonListener());
    }

    class RegresarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.cerrar();
            new MainController(new MainView());
        }
    }

    class ConfirmarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Item> itemsSeleccionados = view.getItemsSeleccionados();
            if (itemsSeleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No has seleccionado ningún ítem.");
                return;
            }

            double precioTotal = calcularPrecioTotal(itemsSeleccionados);
            int numeroMesa = view.getNumeroMesa(); // Obtener el número de mesa seleccionado

            // Crear una nueva orden con los ítems seleccionados y el número de mesa
            Orden nuevaOrden = new Orden(itemsSeleccionados, precioTotal, "pendiente", numeroMesa);

            // Agregar la nueva orden a la lista global de órdenes pendientes
            MainController.ordenesPendientes.add(nuevaOrden);

            view.cerrar();
            new CocinaController(new CocinaView(MainController.ordenesPendientes), MainController.ordenesPendientes);
        }

        private double calcularPrecioTotal(List<Item> items) {
            double total = 0.0;
            for (Item item : items) {
                total += item.getPrecio();
            }
            return total;
        }
    }
}