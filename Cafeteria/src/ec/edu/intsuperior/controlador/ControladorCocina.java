package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Pedido;
import ec.edu.intsuperior.modelo.HistorialPedidos;
import java.util.ArrayList;
import java.util.List;

public class ControladorCocina {
    private List<Pedido> pedidosEnCocina;

    public ControladorCocina() {
        pedidosEnCocina = new ArrayList<>();
    }

    public void recibirPedido(Pedido pedido) {
        pedidosEnCocina.add(pedido);
    }

    public void marcarOrdenLista(Pedido pedido) {
        pedidosEnCocina.remove(pedido);
        HistorialPedidos.agregarPedido(pedido);
    }

    public void cancelarPedido(Pedido pedido) {
        pedidosEnCocina.remove(pedido);
    }

    public List<Pedido> getPedidosEnCocina() {
        return pedidosEnCocina;
    }
}



