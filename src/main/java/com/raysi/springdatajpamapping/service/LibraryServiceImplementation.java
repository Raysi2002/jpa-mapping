package com.raysi.springdatajpamapping.service;

import com.raysi.springdatajpamapping.dto.LibraryDTO;
import com.raysi.springdatajpamapping.entity.Library;
import com.raysi.springdatajpamapping.error.ResourceNotFoundException;
import com.raysi.springdatajpamapping.repository.LibraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<LibraryDTO> fetchLibrary() {
        List<LibraryDTO> libraries = libraryRepository.findAll()
                .stream()
                .map(library -> new LibraryDTO(
                        library.getLibraryName(),
                        library.getBooks(),
                        library.getAddress()
                )).toList();
        if(libraries.isEmpty()){
            throw new ResourceNotFoundException("801", "No libraries present in the database");
        }
        try{
            return libraries;
        }catch (Exception e){
            throw new ResourceNotFoundException("802", "Something went wrong in service layer");
        }
    }
}
