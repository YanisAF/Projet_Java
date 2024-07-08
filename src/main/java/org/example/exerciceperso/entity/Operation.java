package org.example.exerciceperso.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    private final int id;
    private double montant;
    private StatutOperation statut;
    private static int nbOperation = 0;

    public Operation(double montant, StatutOperation statut) {
        this.id = ++nbOperation;
        this.montant = montant;
        this.statut = statut;
    }

//    @Override
//    public String toString() {
//        return "\t-Operation n°" + id +
//                " : montant=" + montant +
//                ", statut=" + statut +
//                '.';
//    } phase de test
}
