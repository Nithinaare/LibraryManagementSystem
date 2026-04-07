package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/new")
    public Book createBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }
    @PutMapping("/edit")
    public void updateBookById(@RequestBody Book book){
         service.updateBookById(book);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable int  id)
    {
        service.deleteBookById(id);
    }

}