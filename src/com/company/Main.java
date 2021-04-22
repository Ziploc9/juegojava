package com.company;

import java.awt.*;
import Characters.*;
import Consumibles.*;
import Utiles.*;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        correrjuego();

    }

    public static void menuStart(){
        System.out.println("\n1- Iniciar juego");
        System.out.println("2- Guardar partida");
        System.out.println("3- Creditos");
        System.out.println("4- Salir juego\n");
    }
    
    public static void menuJuego(){
        System.out.println("\n1- Ir a la casa.");
        System.out.println("2- Buscar madera.");
        System.out.println("3- Buscar piedra.");
        System.out.println("4- Ir a pescar");
    }

    public static void correrjuego(){
        int option=0;
        Personaje personaje = new Personaje("Chaldu",500,20,100,2.4);
        Scanner scan = new Scanner(System.in);

        while (option != 11199207){

            menuStart();
            System.out.println("Tu opcion: ");
            option = scan.nextInt();

            switch (option){

                case 1:

                    scan.nextLine();
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

    /**Switch inicia rol */
                    menuJuego();
                    System.out.print("Elijes: ");
                    option = scan.nextInt();
                    switch(option){

                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        case 4:

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
                    
                    break;

                case 2:
                    System.out.println("¿En serio elegiste esto? ¿Pensas que mi creador es capaz de darme esa habilidad?.");
                    break;

                case 3:
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

                case 4:
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

}