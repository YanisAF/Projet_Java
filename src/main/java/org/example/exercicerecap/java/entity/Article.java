package org.example.exercicerecap.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Article {
    @Id
    @GeneratedValue
    protected int id;
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;
    protected LocalDate restock;

}
