package model;

import java.time.LocalDate;

public class Rutina {

    private int idRutina;
    private String nombre;
    private String objetivo;
    private LocalDate fechaCreacion;

    public Rutina() {
    }

    public Rutina(int idRutina, String nombre, String objetivo, LocalDate fechaCreacion) {
        this.idRutina = idRutina;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return idRutina + " - " + nombre + " | " + objetivo;
    }
}
