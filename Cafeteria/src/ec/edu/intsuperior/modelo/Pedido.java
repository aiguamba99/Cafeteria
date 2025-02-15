package ec.edu.intsuperior.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.getNombre()).append(", ");
        }
        return sb.toString();
    }
}


