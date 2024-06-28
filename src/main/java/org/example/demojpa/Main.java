package org.example.demojpa;

import org.example.demojpa.entity.Computer;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//
//        Computer computer = new Computer();
//        computer.setImac("565656");
//        computer.setCreationDate(LocalDate.now());
//
//        em.persist(computer);
//        em.getTransaction().commit();

        TypedQuery<Computer> query = em.createQuery("select c from Computer c",Computer.class);
        List<Computer> computerList = query.getResultList();

        System.out.println(computerList);

        Computer computer = em.find(Computer.class, 2);


        try{
            Computer computer2 = em.getReference(Computer.class, 1);
            System.out.println(computer2);
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println(computer);

        em.close();
        emf.close();

    }
}
