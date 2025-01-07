package com.raysi.springdatajpamapping.service;

import com.raysi.springdatajpamapping.entity.Library;
import org.springframework.stereotype.Service;

@Service
public interface LibraryService {
    void saveLibrary(Library library);
}
