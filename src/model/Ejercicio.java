package model;

public class Ejercicio {

    private int idEjercicio;
    private String nombre;
    private String grupoMuscular;
    private String descripcion;
    private String urlVideo;

    public Ejercicio() {
    }

    public Ejercicio(int idEjercicio, String nombre, String grupoMuscular, String descripcion, String urlVideo) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.descripcion = descripcion;
        this.urlVideo = urlVideo;
    }

    public Ejercicio(int idEjercicio, String nombre, String grupoMuscular) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public String toString() {
        return idEjercicio + " - " + nombre + " | " + grupoMuscular;
    }
}
