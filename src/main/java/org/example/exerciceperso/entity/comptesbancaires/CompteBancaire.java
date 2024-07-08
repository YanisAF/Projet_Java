package org.example.exerciceperso.entity.comptesbancaires;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.exerciceperso.entity.Client;
import org.example.exerciceperso.entity.Operation;
import org.example.exerciceperso.entity.StatutOperation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CompteBancaire {
    private static int nbCompteBancaire = 0;
    @Id
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

//    @Override
//    public String toString() {
//        String operationsString = "\n";
//        for(Operation operation : operationList){
//            operationsString += operation + "\n";
//            //operationsString += operation.toString() + "\n";
//        }
//
//        return "CompteBancaire n°" + id +
//                " :\n solde=" + solde +
//                ",\n client=" + client +
//                ",\n operationList=" + operationsString +
////                ", operationList=" + operationList +
//                '.';
//    }
}
