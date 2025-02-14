package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Mesa;
import ec.edu.intsuperior.vista.VistaMesas;
import java.util.List;

public class ControladorMesas {
    private VistaMesas vistaMesas;
    private List<Mesa> mesas;

    public ControladorMesas(VistaMesas vistaMesas, List<Mesa> mesas) {
        this.vistaMesas = vistaMesas;
        this.mesas = mesas;
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Aquí agregarás los eventos para los botones de la vista
        // Ejemplo: vistaMesas.getBtnLiberar().addActionListener(e -> liberarMesa());
    }

    // Métodos para manejar la lógica de mesas
    private void liberarMesa() {
        // Lógica para liberar una mesa
    }

    private void ocuparMesa() {
        // Lógica para ocupar una mesa
    }
}
