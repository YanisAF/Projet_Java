package org.example.exercicerecap.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicArticle extends Article{
    private int pourcentBattery;

}
