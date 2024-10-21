package com.example.bookservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookservice.entity.Books;

@Repository
public interface RepositoryBook extends JpaRepository<Books,Long> {
    
}
