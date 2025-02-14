package ec.edu.intsuperior.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private int mesaId;
    private String estado; // Puede ser "Pendiente", "En preparación", "Entregado"
    private double subtotal;
    private List<Producto> productos;

    // Constructor
    public Pedido(int id, int mesaId, String estado, double subtotal) {
        this.id = id;
        this.mesaId = mesaId;
        this.estado = estado;
        this.subtotal = subtotal;
        this.productos = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        subtotal += producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Mesa: " + mesaId + " - Estado: " + estado + " - Subtotal: $" + subtotal;
    }
}
