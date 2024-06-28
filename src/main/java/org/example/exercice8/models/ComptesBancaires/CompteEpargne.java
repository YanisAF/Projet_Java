package org.example.exercice8.models.ComptesBancaires;

import org.example.exercice8.models.Client;

public class CompteEpargne extends CompteBancaire{
    private double taux;

    public CompteEpargne(double solde, Client client, double taux) {
        super(solde, client);
        this.taux = taux;
    }

    public CompteEpargne(Client client, double taux) {
        super(client);
        this.taux = taux;
    }

    public void calculerLesInterets(int anneesPlacement){
        double interrets = 0;
        for (int i = 0; i < anneesPlacement; i++){
            interrets =  this.getSolde() * (taux/100); // on passe parle getter car il est en privé
        }
        this.depot(interrets);
    }
}