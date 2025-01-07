package com.raysi.springdatajpamapping.controller;

import com.raysi.springdatajpamapping.entity.Library;
import com.raysi.springdatajpamapping.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LibraryController {
    private final LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @PostMapping("/libray")
    public ResponseEntity<Library> saveLibrary(@RequestBody Library library){
        try {
            libraryService.saveLibrary(library);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("Accept-Datetime")
                    .body(library);
        }catch (Exception e){
            throw new RuntimeException("Something went wrong");
        }
    }

}
