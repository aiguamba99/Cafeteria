package modelo;

import java.util.List;

public class Orden {
    private List<Item> items;
    private double precioTotal;
    private String estado; // "pendiente" o "completada"
    private int numeroMesa; // Número de mesa asociado a la orden

    public Orden(List<Item> items, double precioTotal, String estado, int numeroMesa) {
        this.items = items;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.numeroMesa = numeroMesa;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }
}