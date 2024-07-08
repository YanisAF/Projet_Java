package org.example.correctionexohibernate.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ProductCloth extends Product{

    private String size;
    private org.example.utils.Categories categories;
}
