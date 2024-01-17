package org.example;

public class CentroData {
    private int id;
    private String nombre;
    private String provincia;
    private String municipio;
    private String localidad;
    private String cp;
    private String calle;

    public CentroData() {
        // Constructor vacío necesario para JasperReports
    }

    public CentroData(int id, String nombre, String provincia, String municipio, String localidad, String cp, String calle) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.municipio = municipio;
        this.localidad = localidad;
        this.cp = cp;
        this.calle = calle;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
