package org.example.exercice8.models.ComptesBancaires;

import org.example.exercice8.models.Client;
import org.example.exercice8.models.Operation;
import org.example.exercice8.models.*;
import org.example.exercice8.models.Client;
import org.example.exercice8.models.Operation;
import org.example.exercice8.models.StatutOperation;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
    private static int nbCompteBancaire = 0;

    private final int id;
    private double solde;
    private Client client;
    private List<Operation> operationList;


    public CompteBancaire(double solde, Client client) {
        this.id = ++nbCompteBancaire;
        this.solde = solde;
        this.client = client;
        this.operationList = new ArrayList<>();
        if(solde > 0)
            this.operationList.add(new Operation(solde, StatutOperation.DEPOT));
    }

    public CompteBancaire(Client client) {
        this(0, client);
    }

    public int getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean depot(double montant){
        if(montant <= 0)
            return false;
        Operation operation = new Operation(montant, StatutOperation.DEPOT);
        operationList.add(operation);
        solde += montant;
        return true;
    }

    public boolean retrait(double montant){
        if(montant <= 0 || solde < montant)
            return false;
        Operation operation = new Operation(montant, StatutOperation.RETRAIT);
        operationList.add(operation);
        solde -= montant;
        return true;
    }

    @Override
    public String toString() {
        String operationsString = "\n";
        for(Operation operation : operationList){
            operationsString += operation + "\n";
            //operationsString += operation.toString() + "\n";
        }

        return "CompteBancaire n°" + id +
                " :\n solde=" + solde +
                ",\n client=" + client +
                ",\n operationList=" + operationsString +
//                ", operationList=" + operationList +
                '.';
    }
}
