package com.raysi.springdatajpamapping.service;

import com.raysi.springdatajpamapping.entity.Library;
import com.raysi.springdatajpamapping.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImplementation implements LibraryService{

    private final LibraryRepository libraryRepository;
    @Autowired
    public LibraryServiceImplementation(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    @Override
    public void saveLibrary(Library library) {
        try{
            libraryRepository.save(library);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong in service layer");
        }
    }
}
