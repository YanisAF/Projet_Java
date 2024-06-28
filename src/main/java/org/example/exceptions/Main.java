package org.example.exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println(" Saisir données: ");
//        String maChaine = scanner.nextLine();
        boolean isFaux = false;
        int converted = 0;

        while(!isFaux){
            System.out.println(" Saisir données: ");

            try {
                String maChaine = scanner.nextLine();
                converted = Integer.parseInt(maChaine);

            }catch (NumberFormatException e){
                System.out.println("Exception");
                System.out.println(e.getMessage());
            }


            System.out.println(converted);
        }
    }
}
