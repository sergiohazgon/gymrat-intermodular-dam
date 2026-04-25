package model;

public class RutinaEjercicio {

    private int idRutina;
    private int idEjercicio;
    private int series;
    private int repeticiones;
    private int orden;

    public RutinaEjercicio() {
    }

    public RutinaEjercicio(int idRutina, int idEjercicio, int series, int repeticiones, int orden) {
        this.idRutina = idRutina;
        this.idEjercicio = idEjercicio;
        this.series = series;
        this.repeticiones = repeticiones;
        this.orden = orden;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Rutina " + idRutina +
                " | Ejercicio " + idEjercicio +
                " | " + series + "x" + repeticiones +
                " | Orden: " + orden;
    }
}
