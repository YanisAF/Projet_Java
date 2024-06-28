package org.example.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jpa.util.RegimeAlimentaire;

import javax.persistence.*;
import java.time.LocalDate;


@Table
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "dateArrive")
    private LocalDate dateArrive;
    private int age;
    @Enumerated
    private RegimeAlimentaire regime;

}
