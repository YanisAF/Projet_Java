package org.example.exercice7;

public class Main {
    public static void main(String[] args) {

        Plante plante = new Plante("Tulipe", 15, "jaune");
        Plante plante2 = new Plante("Hortensia", 10, "rose");

        plante.afficher();
        plante2.afficher();

        Arbre chenes = new Arbre("Chenes", 8, " marron", 5);
        chenes.afficher();
    }
}
