package com.example.libservice.controller;

import com.example.libservice.entity.Book;
import com.example.libservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/v1/book")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/v1/book/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping("/v1/book")
    public ResponseEntity<?> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/v1/book/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
