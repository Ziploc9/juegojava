package com.company;

import java.awt.*;
import Characters.*;
import Consumibles.*;
import Utiles.*;

import java.awt.desktop.SystemSleepEvent;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        correrjuego();
    }

    public static void menuStart(){
        System.out.println("\n1- Iniciar juego");
        System.out.println("2- Controles");
        System.out.println("3- Guardar partida");
        System.out.println("4- Creditos");
        System.out.println("5- Salir juego\n");
    }

    public static void controles(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPara jugar sera algo basico..Tendras que elegir entre algunas opciones '1-4' y presionar enter para skipear textos..");
        System.out.println("Usa 'p' cuando quieras ir al menu principal.");
        System.out.println("Usa 'l' para abrir o cerrar la casa");
        System.out.println("Usa 'i' para abrir el inventorio");
        try
        {
            String seguir = scan.nextLine();
        }
        catch(Exception ignored){}

    }
    
    public static void menuJuego(){
        System.out.println("\n1- Ir a Mimir.");
        System.out.println("2- Buscar madera.");
        System.out.println("3- Buscar piedra.");
        System.out.println("4- Ir a la huerta");
        System.out.println("5- Ir a pescar");
        System.out.println("6- menu principal");
    }

                /**------- Meter info en arraylst----*/

    public static void correrjuego(){
        int option = 0;
        Jugador personaje = new Jugador("Chaldu",200,10,50, 10.2f, 50,50);
        Recurso wood = new Recurso("Arbol",0, 15, true, 20,5);
        Scanner scan = new Scanner(System.in);
        Timer timer = new Timer();                  // timer para actualizar el reinicio de recursos cada 5 minutos


        int acuWood=0;

        while (option != 11199207){

            menuStart();
            System.out.println("Tu opcion: ");
            option = scan.nextInt();

            switch (option){

                case 1:
                    crearPersonaje(personaje,scan);
                    System.out.println("\nErase en 2022 un pueblo alejado llamado 'Apru ebalo' en Hungria. Ya casi no tenia habitantes..");
                    System.out.println("\nDebido a una extraña fabula que se habia originado sobre la luz mala que aparecia a la noche..\n");
                    try
                    {
                        String seguir = scan.nextLine();
                    }
                    catch(Exception ignored){}
                    System.out.println("\n9:00 AM.."+personaje.getNombre()+" llega al pueblo, ves a la gente irse con sus pertenencias, vas a tu casa..");
                    try
                    {
                        String seguir = scan.nextLine();
                    }
                    catch(Exception ignored){}
                    System.out.println("\n Desempacaste y sales afuera..");

    /*Switch inicia rol */
                while (option != 27){
                    System.out.println(personaje);
                    menuJuego();
                    System.out.print("Elijes: ");
                    option = scan.nextInt();
                    switch(option){

                        case 1:// Dormir
                            scan.nextLine();
                            System.out.println("\nEntraste a tu casa..¿Quieres cerrarla? Si | No");
                            String decidir = scan.nextLine();
                            if("Si".equals(decidir) || "s".equals(decidir) || "si".equals(decidir) || "S".equals(decidir)){
                                personaje.cerrarCasa(decidir);
                                if(personaje.dormir() == 0){
                                    System.out.println("\nCerraste tu casa con exito..");
                                    System.out.println("Haciendo la durmision...");
                                    System.out.println("..Despiertas y sales de tu casa..");
                                }else {
                                    System.out.println("\nCerraste tu casa con exito pero..");
                                    System.out.println("No tienes sueño, te quedas afuera disfrutando de lo que odian los otakus y programadores..el sol.");
                                }
                            }else{
                                if(personaje.dormir() == 0){
                                    System.out.println("\nDejaste la puerta sin trabas..muy rudo de tu parte..");
                                    System.out.println("Te animas a dormir...");
                                }else {
                                    System.out.println("\nDejaste la puerta abierta y no tienes sueño..");
                                    System.out.println("Te quedaras afuera disfrutando de lo que odian los otakus y programadores..el sol.");
                                }
                            }
                            break;

                        case 2:// Buscar madera

                            System.out.println("\nMiras los arboles y caminas hacia alli..");
                            gastarEnergia(personaje);
                            if(wood.isEstado()){
                                System.out.println("Tomas el hacha y comenzas a talar..");
                                gastarEnergia(personaje);
                                System.out.println("Madera disponible ["+wood.getCantRecurso()+"/5] ");
                                wood.explotarRecurso();
                                System.out.println("Tienes madera, usa 'g' para guardar o usa 'u' para usar");
                                scan.nextLine();
                                String recolect = scan.nextLine();
                                if("g".equals(recolect)){
                                   acuWood = wood.recolectarRecursos("g", acuWood);
                                    System.out.println("Cargas la madera y la apilas en un costado..");
                                }else if("u".equals(recolect)){
                                   acuWood = wood.recolectarRecursos("u", acuWood);
                                    System.out.println("Agarras las maderas y las usas para mantener caliente tu casa.. ");
                                }else{
                                    System.out.println("¿Sos boludo y no tenes huevos? apreta bien la tecla, no me hagas trabajar mas de lo debido..");
                                }

                            }else{
                                System.out.println("\n¿Acaso quieres deforestar todo el lugar? deja que crezcan los arboles, te dan oxigeno.");
                            }

                                // reinicio recursos cada 50000 milisegundos = 5 minutos
                            TimerTask actualizar = new TimerTask() {
                                @Override
                                public void run() {
                                    wood.reiniciarRecurso();
                                }
                            };
                            timer.schedule(actualizar,50000,10000);

                            break;

                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:

                            break;

                        case 6:
                                option = 27;
                            break;

                            default:
                                System.out.println("¿Por que haces esto? Ahora le voy a subir la vida y el daño al enemigo, segui nomas.");
                                Enemigo enemy = new Enemigo();
                                try
                                {
                                    String seguir = scan.nextLine();
                                }
                                catch(Exception ignored){}
                                enemy.setDamage(enemy.getDamage()+50);
                                enemy.setVida(enemy.getVida()+100);
                                break;
                    }
                 }

                    break;
        /*Switch termino rol */
                case 2:
                    controles();

                    break;

                case 3:
                    System.out.println("¿En serio elegiste esto? ¿Pensas que mi creador es capaz de darme esa habilidad?.");
                    break;

                case 4:
                    System.out.println("Mi creador es el gran Dios Ziploc9.\n");
                    String seguir;
                    Scanner pausa = new Scanner(System.in);
                    System.out.println("* Bip Bup Bap -presiona enter- Bip Bap Soy Un Simple Programa Bup Bip Bap -rapido antes de que venga- Bip Bap *");
                    try
                    {
                        seguir = pausa.nextLine();
                    }
                    catch(Exception ignored){}

                    System.out.println( "¿Estamos a salvo? busque entre sus datos y encontre que se llama Martin Israel Vallejo Torres va a la Comision 3, no le digas, queda entre nosotros.");
                    break;

                case 5:
                    option = 11199207;
                    System.out.println("Adios vuelvas prontos.. Lo siento, mi creador ve mucho Los Simpson.");
                    break;

                default:
                    System.out.println("Oye no te pases de listo, mi creador me aviso sobre personas como tu, introducce bien la opcion.");
                    System.out.println("No me voy a olvidar de esto humano.. te va a ser mas dificil matar a tu enemigo ahora.");
                    Enemigo enemigo = new Enemigo();
                    enemigo.setResistencia(enemigo.getResistencia()+100);
                    break;
            }

        }
    }

    public static void crearPersonaje(Personaje person,Scanner scan){
        scan.nextLine();
        System.out.println("Bienvenido a Farmer Warrior (a mi creador no se le ocurrio algo mejor) ¿Quiere ponerle un nombre a su personaje? Yes | No\n");
        String option = scan.nextLine();
        if("Yes".equals(option) || "yes".equals(option) || "y".equals(option) || "Y".equals(option)){
            System.out.println("\n Nombre de su personaje: ");
            person.setNombre(scan.nextLine());
            System.out.println("Loading.. mentira no tengo esa tecnologia, vamos a la historia.\n");
            try
            {
                String seguir = scan.nextLine();
            }
            catch(Exception ignored){}

        }else{

            System.out.println("\n Bien ehm.. las personas que usan este programa suelen elegirse un nombre.. no soy bueno para esto..");
            System.out.println("\n Dejame busco en mi disco duro -Bip Bap Bup-  Bien te llamare Chaldu, bueno vamos a ello..");
            try
            {
                String seguir = scan.nextLine();
            }
            catch(Exception ignored){}
        }
    }

    public static void gastarEnergia(Jugador personaje){
        personaje.setCansancio(personaje.getCansancio()-1.5f);
        personaje.setHambre(personaje.getHambre()-0.50f);
        if(personaje.getCansancio()<=0 || personaje.getHambre() <= 0){
            personaje.setResistencia(personaje.getResistencia()-20);
            personaje.setVelocidad(personaje.getVelocidad()-1.5f);
        }else if(personaje.getResistencia()<=0){
            personaje.setVida(personaje.getVida()-30);
        }
    }

    public static void inventario(Jugador pers){

    }


}