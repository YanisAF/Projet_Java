package org.example.exerciceperso.entity.comptesbancaires;

import org.example.exerciceperso.entity.Client;

public class ComptePayant extends CompteBancaire{
    private double coutOperation = 0.5;

    public ComptePayant(double solde, Client client) {
        super(solde, client);
    }

    @Override
    public boolean depot(double mt){
        if(this.getSolde() < coutOperation){
            return  false;
        }
        super.depot(mt);
        return  super.retrait(coutOperation);
    }

    @Override
    public boolean retrait(double mt){
        if(mt <= coutOperation || this.getSolde() < (mt + coutOperation)){
            return false;
        }
        super.retrait(mt);
        return super.retrait(coutOperation);
    }
}
