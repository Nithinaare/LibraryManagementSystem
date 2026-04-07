package com.example.demo.service;

import com.example.demo.entity.Borrow;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.example.demo.exception.ResourceNotFoundException;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BookRepository brepo;

    @Transactional
    public Borrow newBorrow(Borrow borrow) {

        Book book = brepo.findById((long)borrow.getBid())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (book.getCount() <= 0) {
            throw new RuntimeException("Book not available");
        }

        brepo.decreaseCount(borrow.getBid());

        return repository.save(borrow);
    }
    @Transactional
    public List<Borrow> getAllBorrows()
    {
        return repository.findAll();
    }

    @Transactional
    public String returning(Borrow borrow) {


        borrow.setReturnDate(LocalDate.now());



        repository.updateReturn(
                borrow.getBid(),
                borrow.getCid(),
                borrow.getReturnDate()
        );


        brepo.increaseCount(borrow.getBid());

        return "Successfully returned";
    }
}