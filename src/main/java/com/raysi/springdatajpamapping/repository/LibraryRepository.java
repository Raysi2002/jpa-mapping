package com.raysi.springdatajpamapping.repository;

import com.raysi.springdatajpamapping.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
