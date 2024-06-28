package org.example.exercice4;

public class WaterTank {
    private int fillLevel;
    private int maxCapacity;
    private int weightEmpty;
    private static int totalFillLevels = 0;

    public WaterTank(int fillLevel, int maxCapacity, int weightEmpty) {
//        totalFillLevels += fillLevel;
//        this.fillLevel = fillLevel;
        this.setFillLevel(fillLevel); // remplace les 2 lignes précédentes
        this.maxCapacity = maxCapacity;
        this.weightEmpty = weightEmpty;
    }

    public void setFillLevel(int fillLevel) {
        // possible de lever une erreur si fillLevel est négatif
        totalFillLevels -= this.fillLevel;
        this.fillLevel = fillLevel;
        totalFillLevels += fillLevel;
    }

    public static int getTotalFillLevels() {
        return totalFillLevels;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

//    public int getWeightEmpty() {
//        return weightEmpty;
//    }

    public int getTotalWeight() {
        return fillLevel + weightEmpty;
    }

    public int fill(int amount)
    {
        if (amount <= 0)
            return 0;

        if (fillLevel + amount > maxCapacity)                     // est-ce que le montant dépasse la capacité maximum de la citerne
        {
            int excessWater = fillLevel + amount - maxCapacity;   // je calcule le montant d'eau en surplus
            setFillLevel(maxCapacity);                            // elle est maintenant pleine
            return excessWater;                                   // on "rends" le surplus d'eau
        }
        else                                                      // dans le cas où on ne dépasse pas le maximum
        {
            setFillLevel(fillLevel + amount);
            return 0;                                             // on ne retourne aucun surplus d'eau
        }
    }

    public int empty(int amount)
    {
        if (amount <= 0)
            return 0;

        if (fillLevel - amount < 0)                                // est-ce que le montant dépasse la capacité minimum de la citerne
        {
            int waterTaken = fillLevel;                            // on récupère le contenu de la citerne
            setFillLevel(0);                                       // la citerne est donc vide
            return waterTaken;                                     // on retourne la quantité qu'on a récupérée
        }
        else                                                       // dans le cas où on ne dépasse pas le minimum
        {
            setFillLevel(fillLevel - amount);
            return amount;                                         // on retourne la quantité demandée d'eau
        }
    }

    public void affichageCiterne()
    {
        String[][] citerneAscii = {
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
        };
        int niveauCiterne = this.fillLevel == 1 ? 1 : (this.fillLevel * 8 / this.maxCapacity);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(citerneAscii[niveauCiterne][i]);
        }
    }
}
