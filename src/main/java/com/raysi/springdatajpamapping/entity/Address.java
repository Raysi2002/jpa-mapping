package com.raysi.springdatajpamapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Max(6)
    @Min(6)
    @Id
    private String pinCode;

    private String city;

    private String state;

    private String country;
}
