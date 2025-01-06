package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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

    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    private Address address;

    @OneToMany(
            cascade = CascadeType.PERSIST

    )
    private Book book;


}
