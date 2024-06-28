package org.example.exercice3;

public class Main {
    public static void main(String[] args) {

        Joueur un = new Joueur("Joueur 1");

        for (int i = 0; i < 11; i++) {
            un.effectuerUneQuete();
            System.out.println(un);
        }
    }
}
