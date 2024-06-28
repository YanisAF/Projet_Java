package org.example.exercice2;

import java.time.LocalDate;

public class Film {
    String titre;
    String realisateur;
    LocalDate anneeDeSortie = LocalDate.of(2020, 1, 8);
    String genre;


public Film (String titreParam, String realisateur, LocalDate anneeDeSortie, String genre){
    titre = titreParam;
    this.realisateur = realisateur;
    this.anneeDeSortie = anneeDeSortie;
    this.genre = genre;
 }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) { this.titre = titre; }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) { this.realisateur = realisateur; }

    public LocalDate getAnneeDeSortie() { return anneeDeSortie; }

    public void setAnneeDeSortie(LocalDate anneeDeSortie) { this.anneeDeSortie = anneeDeSortie; }

    public String getGenre() { return genre; }

    public void getGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", anneeDeSortie=" + anneeDeSortie +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void afficher(){
        System.out.println(this);
    }
}
