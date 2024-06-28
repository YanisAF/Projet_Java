package org.example.exercice8;

import org.example.exercice8.models.Client;
import org.example.exercice8.models.ComptesBancaires.CompteBancaire;
import org.example.exercice8.models.ComptesBancaires.CompteCourant;
import org.example.exercice8.models.ComptesBancaires.CompteEpargne;
import org.example.exercice8.models.ComptesBancaires.ComptePayant;
import org.example.exercice8.models.Client;
import org.example.exercice8.models.ComptesBancaires.CompteBancaire;
import org.example.exercice8.models.ComptesBancaires.CompteCourant;
import org.example.exercice8.models.ComptesBancaires.CompteEpargne;
import org.example.exercice8.models.ComptesBancaires.ComptePayant;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Lhomme", "Léo", "0607080910");

        System.out.println(client);

        CompteBancaire compte = new CompteCourant(100, client);
        compte.depot(50);
        compte.retrait(149);
        System.out.println(compte);


        CompteBancaire compte2 = new CompteEpargne(102, client, 5);
        System.out.println(compte2);
        ((CompteEpargne) compte2).calculerLesInterets(5);
        System.out.println(compte2);


        CompteBancaire compte3 = new ComptePayant(1003, client);
        compte3.depot(50);
        compte3.retrait(149);
        System.out.println(compte3);
    }
}
