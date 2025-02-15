package ec.edu.intsuperior.modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialPedidos {
    private static List<Pedido> historial = new ArrayList<>();

    public static void agregarPedido(Pedido pedido) {
        historial.add(pedido);
    }

    public static List<Pedido> getHistorial() {
        return historial;
    }
}



