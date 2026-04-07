package com.example.demo.repository;

import com.example.demo.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.bname = :name, b.avail = :avail ,b.count = :count WHERE b.id=:id")
    void updateBook(String name, String avail, int count ,int id);
    void deleteBooksById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.count = b.count - 1 WHERE b.id = :id")
    void decreaseCount(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.count = b.count + 1 WHERE b.id = :id")
    void increaseCount(int id);

    @Query("select b.count from Book b where b.id=:id ")
    int getCount(int id);


}