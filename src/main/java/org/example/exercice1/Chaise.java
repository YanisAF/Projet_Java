package org.example.exercice1;

public class Chaise {
    private int nbr;
    private String materiaux;
    private String couleur;

    public Chaise(int nbrPieds, String materiaux, String couleur){
        this.nbr = nbrPieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec "+nbr+" pied(s) en chaine de couleur "+ couleur+ " construit en "+materiaux;
    }
}
