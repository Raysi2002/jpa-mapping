package com.raysi.springdatajpamapping.service;

import com.raysi.springdatajpamapping.entity.Library;
import com.raysi.springdatajpamapping.repository.LibraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryServiceImplementation implements LibraryService{

    private final LibraryRepository libraryRepository;
    @Autowired
    public LibraryServiceImplementation(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    @Override
    public void saveLibrary(Library library) {
        try {
            libraryRepository.save(library);
        } catch (Exception e) {
            e.printStackTrace(); // Add logging here
            throw new RuntimeException("Error saving library: " + e.getMessage());
        }
    }
}
