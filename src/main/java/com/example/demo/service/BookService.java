package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
    public void updateBookById(Book book)
    {
         repository.updateBook(book.getBname(),book.getAvail(),book.getCount(),book.getId());
    }
    public void deleteBookById(int id)
    {
        repository.deleteBooksById(id);
    }

}