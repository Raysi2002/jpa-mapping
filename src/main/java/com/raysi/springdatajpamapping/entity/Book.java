package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_seq"
    )
    @SequenceGenerator(
            name = "author_seq",
            sequenceName = "author_sequence",
            allocationSize = 116
    )
    private Long authorId;
    private String bookName;
    private String genre;
    @ManyToMany(

    )
    private List<Author> authors;
}
