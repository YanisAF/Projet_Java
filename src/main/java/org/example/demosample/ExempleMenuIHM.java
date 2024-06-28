package org.example.demosample;

import java.util.Scanner;

public class ExempleMenuIHM {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> choixOne();
                case "2" -> choixTwo();
                case "3" -> choixThree();
                case "4" -> choixFour();
                case "0" -> {
                    System.out.println("Au revoir !!!");
                    return; // ou break; ou System.exit(0); (termine l'application)
                }
                default -> System.out.println("Choix invalide !!!!");
            }

        }
    }

    public static void afficheMenuBase(){
        System.out.println("##### Menu Base #######");
        System.out.println("1) Choix un");
        System.out.println("2) Choix deux");
        System.out.println("3) Choix trois");
        System.out.println("4) Choix quatre");
        System.out.println("0) Quitter");
        System.out.print("Faite votre choix : ");
    }

    public static void choixOne(){
        System.out.println("Vous avez fait le choix 1");
    }

    public static void choixTwo(){
        System.out.println("Vous avez fait le choix 2");
    }

    public static void choixThree(){
        System.out.println("Vous avez fait le choix 3");
    }

    public static void choixFour(){
        System.out.println("Vous avez fait le choix 4");
    }

}