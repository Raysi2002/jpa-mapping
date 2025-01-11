package com.raysi.springdatajpamapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_seq"
    )
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_sequence",
            allocationSize = 116
    )
    private Long bookId;
    @NotNull
    private String bookName;
    @NotNull
    private String genre;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    @JsonIgnore
    private Library library;
}
