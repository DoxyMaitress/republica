package org.example;

public class UrgenciasData {
    private int id;
    private String razon;
    private int cantidad;
    private int centroId;

    public UrgenciasData() {
        // Constructor vacío necesario para JasperReports
    }

    public UrgenciasData(int id, String razon, int cantidad, int centroId) {
        this.id = id;
        this.razon = razon;
        this.cantidad = cantidad;
        this.centroId = centroId;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCentroId() {
        return centroId;
    }

    public void setCentroId(int centroId) {
        this.centroId = centroId;
    }
}
