package org.example;

public class MedicosData {
    private int id;
    private String nombre;
    private String especialidad;
    private int centroId;

    public MedicosData() {
        // Constructor vacío necesario para JasperReports
    }

    public MedicosData(int id, String nombre, String especialidad, int centroId) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.centroId = centroId;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCentroId() {
        return centroId;
    }

    public void setCentroId(int centroId) {
        this.centroId = centroId;
    }
}
