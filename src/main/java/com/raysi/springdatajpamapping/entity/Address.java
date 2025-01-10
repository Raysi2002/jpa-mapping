package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_seq"
    )
    @SequenceGenerator(
            name = "address_seq",
            sequenceName = "address_sequence",
            allocationSize = 116
    )
    private Long addressCode;
    private String pinCode;

    private String city;

    private String state;

    private String country;
}
