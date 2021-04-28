package Characters;

import java.util.Scanner;

public class Jugador extends Personaje {

    private float cansancio;
    private float hambre;
    private boolean lock;

    public Jugador(String nombre, int vida, int damage, int resistencia, float velocidad, float cansancio, float hambre){
        super(nombre,vida,damage,resistencia,velocidad);
        this.cansancio = cansancio;
        this.hambre = hambre;
    }


    /**---Get&Set---*/
    public float getCansancio() {
        return cansancio;
    }

    public void setCansancio(float cansancio) {
        this.cansancio = cansancio;
    }

    public float getHambre() {
        return hambre;
    }

    public void setHambre(float hambre) {
        this.hambre = hambre;
    }

    public boolean getLock(){
        return lock;
    }

    public void setLock(boolean lock){
        this.lock = lock;
    }


    /**---Methods---*/

   public int dormir(){
       int suenio = 50;
       if(getCansancio()< suenio){
           setCansancio(suenio);
        return 0;
       }else{
           return 1;
       }
   }

    public static void agarrarObjeto(){

    }

    public static void recolectar(){

    }

    public static void guardarObjeto(){

    }

    public static void sacarObjeto(){

    }

    public static void verInventario(){

    }

    public static void construir(){

    }

    public int comer(){
        int fullHambre = 50;
        if(getHambre()< fullHambre){
            setHambre(fullHambre);
            return 0;
        }else{
            return 1;
        }
    }

    public static void defenderse(){

    }

    public void cerrarCasa(String cerrar){
       if("l".equals(cerrar) || "L".equals(cerrar)){
           this.setLock(true);
       }else {
           this.setLock(false);
       }
    }

    @Override
    public String toString(){
       double sue = getCansancio();
       
       StringBuilder s = new StringBuilder("\n-Informacion-\n");
       s.append("Nombre[").append(getNombre()).append("] " );
       s.append("Vida[").append(getVida()).append("/200] ");
       s.append("Armadura [").append(getResistencia()).append("/50] ");
       s.append("Damage [").append(getDamage()).append("/200]");
       s.append("Hambre [").append(getHambre()).append("/50.0] ");
       s.append("Sueño [").append(getCansancio()).append("/50.0] ");
       s.append("Velocidad [").append(getVelocidad()).append("/10.2] ");

       return s.toString();
    }

}
