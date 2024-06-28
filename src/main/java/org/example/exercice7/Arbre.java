package org.example.exercice7;

public class Arbre extends Plante{
    private int circonference;
    public Arbre(String nom, int hauteur, String couleur, int circonference) {
        super(nom, hauteur, couleur);
        this.circonference = circonference;
    }

    @Override
    public String toString() {
        return super.toString() + " "+ this.circonference;
    }
}
