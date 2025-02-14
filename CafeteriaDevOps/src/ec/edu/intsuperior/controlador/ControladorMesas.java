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
        // Ejemplo de eventos para liberar y ocupar mesa
        vistaMesas.getBtnLiberar().addActionListener(e -> liberarMesa());
        vistaMesas.getBtnOcupar().addActionListener(e -> ocuparMesa());
    }

    // Lógica para liberar una mesa
    private void liberarMesa() {
        System.out.println("Liberar mesa...");
        // Aquí se debe implementar la actualización del estado de la mesa.
    }

    // Lógica para ocupar una mesa
    private void ocuparMesa() {
        System.out.println("Ocupar mesa...");
        // Aquí se debe implementar la actualización del estado de la mesa.
    }
}

