package org.example;

import org.example.demo00bases.GenreEnum;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GenreEnum genre = GenreEnum.Fem;
        System.out.println(genre);

        // Ternaires

        String chaine = 1<2 ? "Inferieur" : "Superieur";
    }
}