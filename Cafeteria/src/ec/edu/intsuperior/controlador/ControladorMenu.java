package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Pedido;
import ec.edu.intsuperior.modelo.Producto;
import ec.edu.intsuperior.vista.VistaMenu;

public class ControladorMenu {
    private VistaMenu vistaMenu;
    private Pedido pedido;

    public ControladorMenu() {
        pedido = new Pedido();
    }

    public void setVistaMenu(VistaMenu vistaMenu) {
        this.vistaMenu = vistaMenu;
    }

    public void agregarProducto(Producto producto) {
        pedido.agregarProducto(producto);
        if (vistaMenu != null) {
            vistaMenu.actualizarListaPedido();
        }
    }

    public Pedido getPedido() {
        return pedido;
    }
}




