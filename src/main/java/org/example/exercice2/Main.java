package org.example.exercice2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Film un = new Film("La Haine", "Matthieu Kassovitz", LocalDate.of(1995,05,31), "Drame");
        Film deux = new Film("Avatar 2", "James Cameron", LocalDate.of(2022,12,14), "Action");

        System.out.println(deux.toString());
        System.out.println(un.toString());

        un.afficher();

    }

}
