package org.example.exercice7;

public class Plante {
    private String nom;
    private int hauteur;
    private String couleur;

    public Plante(String nom, int hauteur, String couleur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public void afficher(){
        System.out.println(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + "{" +
                "Méthode tostring du parent/super => " +
                nom +" " +hauteur +" "+ couleur;
    }


}
