package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService service;
    @GetMapping
    public List<Borrow> getBooks() {
        return service.getAllBorrows();
    }
    @PostMapping("/new")
    public Borrow newBook(@RequestBody Borrow borrow)
    {
        return service.newBorrow(borrow);
    }
    @PutMapping("/return")
    public String returning(@RequestBody Borrow borrow)
    {
        return service.returning(borrow);
    }

}
