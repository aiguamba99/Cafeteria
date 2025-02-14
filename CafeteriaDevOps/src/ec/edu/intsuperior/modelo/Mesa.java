package ec.edu.intsuperior.modelo;

public class Mesa {
    private int id;
    private String estado; // "Disponible" o "Ocupada"

    public Mesa(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

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
