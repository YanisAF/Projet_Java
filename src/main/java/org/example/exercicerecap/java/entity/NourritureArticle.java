package org.example.exercicerecap.java.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NourritureArticle extends Article {
    private LocalDate datePeremption;

    // Pas nécessaire d'ajouter un constructor
//    public NourritureArticle(int id, String name, String description, double price, int quantity, LocalDate restock, LocalDate dateP){
//        super(id, name, description, price, quantity, restock);
//    this.datePeremption = dateP; }


}
