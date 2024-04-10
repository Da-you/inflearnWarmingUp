package com.group.libearyapp.app.book.repository;

import com.group.libearyapp.app.book.domain.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findByName(String name);

}
