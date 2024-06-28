


package org.example.exercicebdd;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String isbn10;
    private String getIsbn13;
    private LocalDate publicationDate;

}
