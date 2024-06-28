package org.example.jpa.persistence;

import org.example.jpa.entity.Animal;
import org.example.jpa.util.RegimeAlimentaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalRepository {
    private EntityManager em;

    public AnimalRepository(EntityManager em) { this.em = em; }

    public void create(Animal animal) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(animal);
        transaction.commit();
    }

    public Animal findByID(int id) {
        return em.find(Animal.class,id);
    }

    public List<Animal> findByName(String nameSearch) {
        // TypedQuery permet de preciser le type d'objet qui sera renvoyé par notre query
        TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.name like :nameSearchQuery", Animal.class);
        //setparameter (nom_du_parametre, valeur_souhaitée_pour_le_parametre)
        //ajout des % via la concatenation pour pouvoir les utiliser avec le like
        query.setParameter("nameSearchQuery","%"+nameSearch+"%");
        List<Animal> animals  = query.getResultList();
        return animals;
    }

    public List<Animal> findByDiet (RegimeAlimentaire dietSearch){
        TypedQuery<Animal> query = em.createQuery("select a from Animal a where a.diet = :dietSearchQuery",Animal.class);
        query.setParameter("dietSearchQuery",dietSearch);
        return query.getResultList();
    }
}
