package org.example.exercicebdd1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    private int id;
    private int numberClasse;
    private String surname;
    private String name;
    private LocalDate DateDiplome;
}
