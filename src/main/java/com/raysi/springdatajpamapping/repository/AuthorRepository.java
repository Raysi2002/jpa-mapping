package com.raysi.springdatajpamapping.repository;

import com.raysi.springdatajpamapping.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
