package Consumibles;

public abstract class TipoRecurso {
    private double saciarHambre;
    private String nombre;

    public double getSaciarHambre() {
        return saciarHambre;
    }

    public void setSaciarHambre(double saciarHambre) {
        this.saciarHambre = saciarHambre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    abstract void crecer();

    abstract void existir();
}
