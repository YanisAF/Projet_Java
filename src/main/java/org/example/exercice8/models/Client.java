package org.example.exercice8.models;


import org.example.exercice8.models.ComptesBancaires.CompteBancaire;
import org.example.exercice8.models.ComptesBancaires.CompteBancaire;

import java.util.ArrayList;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void addCompteBancaire(CompteBancaire compteBancaire){
        compteBancaireList.add(compteBancaire);
    }

    public List<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    @Override
    public String toString() {
        return "Client n°" + id +
                " : nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                '.';
    }
}
