package org.example.exerciceperso.entity.comptesbancaires;

import org.example.exerciceperso.entity.Client;

public class CompteCourant extends CompteBancaire{
    public CompteCourant(double solde, Client client) {
        super(solde, client);
    }
}
