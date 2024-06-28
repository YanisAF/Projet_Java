package org.example.exercice3;

public class Joueur {
        String nom;
        int niveau = 1;
        int points = 0;

        public Joueur (String nomParam){
            this.nom = nomParam;
        }

        public String getNom() { return nom; }

        public int getNiveau() { return niveau; }

        public int getPoints() { return points; }


        public void effectuerUneQuete(){
           this.points += 10;

            setPoints();
        }

        private void setPoints(){
            if(this.points > 100){
                this.niveau++;
                this.points = 0;
                System.out.println(nom+points);
            }
        }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", points=" + points +
                '}';
    }
}
