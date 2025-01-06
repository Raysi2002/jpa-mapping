package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
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
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    @Email
    private String authorEmail;
    @NotNull
    private String phoneNo;
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "authorId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "bookId"
            )
    )
    private List<Book> books;
}
