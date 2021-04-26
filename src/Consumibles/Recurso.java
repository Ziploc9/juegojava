package Consumibles;

import java.util.ArrayList;

public class Recurso{

    private String nombre;
    private double saciarHambre;
    private int cantRecurso;
    private int resistencia;
    private boolean estado;
    private int tiempoMadurez;

    public Recurso(String nombre, double saciarHambre, int resistencia, boolean estado, int tiempoMadurez, int cantRecurso){
        this.nombre = nombre;
        this.saciarHambre = saciarHambre;
        this.resistencia = resistencia;
        this.estado = estado;
        this.tiempoMadurez = tiempoMadurez;
        this.cantRecurso = cantRecurso;
    }

    /**--GET&SET--*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaciarHambre() {
        return saciarHambre;
    }

    public void setSaciarHambre(double saciarHambre) {
        this.saciarHambre = saciarHambre;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTiempoMadurez() {
        return tiempoMadurez;
    }

    public void setTiempoMadurez(int tiempoMadurez) {
        this.tiempoMadurez = tiempoMadurez;
    }

    public int getCantRecurso() {
        return cantRecurso;
    }

    public void setCantRecurso(int cantRecurso) {
        this.cantRecurso = cantRecurso;
    }

    /**--Methods--*/
                            //acumula la cant de madera y tiene limite 50
    public int recolectarRecursos(String check, int acumuladorWood){
        int woodMAX = 50;
        if ("g".equals(check) && acumuladorWood <= woodMAX){
                acumuladorWood++;
        }else if(acumuladorWood > woodMAX){
            System.out.println("\nTienes demasiada madera acumulada ¿Acaso no piensas en mi procesador?");
        }
                                     //va restando 1 segun recurso explotado
        if("u".equals(check) && acumuladorWood < woodMAX){
                acumuladorWood--;
        }else if(acumuladorWood <= 0){
            System.out.println("\nNo tienes madera para usar..");
        }
        return acumuladorWood;
    }

    public void explotarRecurso(){
        if(this.getCantRecurso() >0){
            this.setCantRecurso(this.getCantRecurso()-1);
        }else{
            this.setEstado(false);
        }
    }

    public void reiniciarRecurso(){
        if(getCantRecurso() == 0){
            setCantRecurso(5);
        }
    }

    public boolean crecer() {
        setEstado(false);

        return isEstado();
    }

    public boolean existir(){
       setEstado(true);

        return isEstado();
    }

}
