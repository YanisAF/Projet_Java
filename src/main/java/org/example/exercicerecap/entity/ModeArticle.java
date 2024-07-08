package org.example.exercicerecap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModeArticle extends Article{
    private GenreModeArticle typeArticle;
    private int taille;
}
