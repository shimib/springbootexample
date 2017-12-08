package com.example.demo2.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long>{
    List<Book> getBooksByPriceLessThan(int price);
    Book getBookByTitle(String title);
}
