package com.example.demo.repository;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




import java.time.LocalDate;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
  @Modifying
  @Transactional
  @Query("UPDATE Borrow b SET b.returnDate=:date WHERE b.bid=:bid and b.cid=:cid")
  void updateReturn(int bid,int cid,LocalDate date);

}