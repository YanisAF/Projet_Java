package org.example.exercice8.models.ComptesBancaires;

import org.example.exercice8.models.Client;

public class CompteCourant extends CompteBancaire{
    public CompteCourant(double solde, Client client) {
        super(solde, client);
    }

    public CompteCourant(Client client) {
        super(client);
    }
}
