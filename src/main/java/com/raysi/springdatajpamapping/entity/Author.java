package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String firstName;
    private String middleName;
    private String lastName;
    @Email
    private String authorEmail;
    private String phoneNo;
    private List<Book> books;
}
