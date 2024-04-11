package com.group.libearyapp.app.book;

import com.group.libearyapp.app.book.dto.request.BookLoanRequest;
import com.group.libearyapp.app.book.dto.request.BookReturnRequest;
import com.group.libearyapp.app.book.dto.request.CreateBookRequest;
import com.group.libearyapp.app.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/book")
  public void saveBook(@RequestBody CreateBookRequest request){
    bookService.saveBook(request);
  }

  @PostMapping("/book/loan")
  public void loanBook(@RequestBody BookLoanRequest request){
    bookService.loanBook(request);
  }

  @PutMapping("/book/return")
  public void returnBook(@RequestBody BookReturnRequest request){
    bookService.returnBook(request);
  }
}
