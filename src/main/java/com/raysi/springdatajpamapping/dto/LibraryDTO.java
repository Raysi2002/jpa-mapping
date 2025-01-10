package com.raysi.springdatajpamapping.dto;

import com.raysi.springdatajpamapping.entity.Address;
import com.raysi.springdatajpamapping.entity.Book;

import java.util.List;

public record LibraryDTO(
        String libraryName,
        List<Book> books,
        Address address
        ) {

}
