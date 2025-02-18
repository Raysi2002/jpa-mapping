package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Library {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "library_seq"
    )
    @SequenceGenerator(
            name = "library_seq",
            sequenceName = "library_sequence",
            allocationSize = 116
    )
    private Long libraryId;
    private String libraryName;


    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "address_code", referencedColumnName = "addressCode")
    private Address address;

    @OneToMany(mappedBy = "library", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;

}