package ec.edu.intsuperior.modelo;

public class Mesa {
    private int id;
    private String estado; // Puede ser "Disponible" o "Ocupada"

    // Constructor
    public Mesa(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesa #" + id + " - Estado: " + estado;
    }
}
