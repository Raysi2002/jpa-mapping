package com.raysi.springdatajpamapping.service;

import com.raysi.springdatajpamapping.dto.LibraryDTO;
import com.raysi.springdatajpamapping.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {
    void saveLibrary(Library library);
    List<LibraryDTO> fetchLibrary();
}
