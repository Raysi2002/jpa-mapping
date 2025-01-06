package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_seq"
    )
    @SequenceGenerator(
            name = "author_seq",
            sequenceName = "address_sequence",
            allocationSize = 116
    )
    private Long addressCode;
    @Max(6)
    @Min(6)
    private String pinCode;

    private String city;

    private String state;

    private String country;
}
