package com.example.bookservice.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookservice.entity.Books;
import com.example.bookservice.repo.RepositoryBook;
import com.speedment.jpastreamer.application.JPAStreamer;

@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    private RepositoryBook repositoryBook;


    @Autowired
    private JPAStreamer jpaStreamer;

    

    @PostMapping("/books")
    public Books addBook(@RequestBody Books book)
    {
        return repositoryBook.save(book);
    }

    @GetMapping("/books/{bid}")
    public Books getAbook(@PathVariable("bid") long bid)
    {
        return repositoryBook.findById(bid).get();
    }


    @GetMapping("/books")
    public List<Books> getAllBooks()
    {
        return repositoryBook.findAll();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable("id") long id)
    {
        repositoryBook.deleteById(id);
    }

    @GetMapping("/book/{name}")
    public Map<String,Long> getBookByNameAndQuantity(@PathVariable String name) {
        // try (var stream = repositoryBook.findAll().stream()) {
        //     return stream
        //         .filter(book -> book.getName().equalsIgnoreCase(name) && book.getQuantity() >= 3)
        //         .findFirst()
        //         .orElse(null); // Return null if no book matches
        // }

         return jpaStreamer.stream(Books.class).
         filter(book -> book.getName().equals(name))
          .collect(Collectors.groupingBy(Books::getName, Collectors.counting()));

    }

    
}
