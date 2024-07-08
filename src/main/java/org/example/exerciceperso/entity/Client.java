package org.example.exerciceperso.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.exercice8.models.ComptesBancaires.CompteBancaire;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@Data
public class Client {

    private static int nbClient = 0;

    private final int id;
    private String nom;
    private String prenom;
    private String telephone;
    private final List<CompteBancaire> compteBancaireList;

    public Client(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.id = ++nbClient;
        this.compteBancaireList = new ArrayList<>(); // si on oublie, compteBancaireList == null
    }

//    @Override
//    public String toString() {
//        return "Client n°" + id +
//                " : nom='" + nom + '\'' +
//                ", prenom='" + prenom + '\'' +
//                ", telephone='" + telephone + '\'' +
//                '.';
//    }
}
