package com.raysi.springdatajpamapping.controller;

import com.raysi.springdatajpamapping.dto.LibraryDTO;
import com.raysi.springdatajpamapping.entity.Library;
import com.raysi.springdatajpamapping.error.ResourceNotFoundException;
import com.raysi.springdatajpamapping.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LibraryController {
    private final LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/lib")
    public ResponseEntity<List<LibraryDTO>> getLibrary(){
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .header("Accept-Datetime")
                    .body(libraryService.fetchLibrary());
        }catch (ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new ResourceNotFoundException("803", "Something went wrong in Controller layer");
        }
    }

    @PostMapping("/lib")
    public ResponseEntity<?> saveLibrary(@RequestBody Library library) {
        try {
            libraryService.saveLibrary(library);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("Accept-Datetime")
                    .body(library);
        } catch (Exception e) {
            e.printStackTrace(); // Add logging here
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

}
