package com.raysi.springdatajpamapping.repository;

import com.raysi.springdatajpamapping.entity.Address;
import com.raysi.springdatajpamapping.entity.Author;
import com.raysi.springdatajpamapping.entity.Book;
import com.raysi.springdatajpamapping.entity.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryRepositoryTest {
    private final LibraryRepository libraryRepository;
    @Autowired
    public LibraryRepositoryTest(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    @Test
    public void insert(){
        try{

            Address address = Address.builder()
                    .pinCode("116611")
                    .city("Laukahi")
                    .state("Koshi")
                    .country("Nepal")
                    .build();

            List<Author> authors = Stream.of(
                    Author.builder()
                            .authorEmail("2002raysi@gmail.com")
                            .firstName("Aashish")
                            .middleName("Ray")
                            .lastName("Ray")
                            .phoneNo("9848278176")
                            .build()
            ).collect(Collectors.toList());

            List<Book> books = Stream.of(
                    Book.builder()
                            .bookName("Our Journey")
                            .genre("Real Life")
                            .authors(authors)
                            .build()
            ).collect(Collectors.toList());


            Library library = Library.builder()
                    .libraryName("Ray's Library")
                    .address(address)
                    .books(books)
                    .build();
            libraryRepository.save(library);


        }catch (Exception e){
            throw new RuntimeException("Kuch to gadbad hai daya kuch to gadbad hai!");
        }
    }
}