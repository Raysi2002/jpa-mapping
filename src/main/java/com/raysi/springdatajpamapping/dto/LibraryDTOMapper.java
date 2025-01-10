package com.raysi.springdatajpamapping.dto;

import com.raysi.springdatajpamapping.entity.Library;

import java.util.function.Function;

public class LibraryDTOMapper implements Function<Library, LibraryDTO> {

    @Override
    public LibraryDTO apply(Library library) {
        return new LibraryDTO(
                library.getLibraryName(),
                library.getBooks(),
                library.getAddress()
        );
    }
}
