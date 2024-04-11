package com.group.libearyapp.app.book.service;


import com.group.libearyapp.app.book.domain.Book;
import com.group.libearyapp.app.book.dto.request.BookLoanRequest;
import com.group.libearyapp.app.book.dto.request.BookReturnRequest;
import com.group.libearyapp.app.book.dto.request.CreateBookRequest;
import com.group.libearyapp.app.book.repository.BookRepository;
import com.group.libearyapp.app.user.domain.User;
import com.group.libearyapp.app.user.repository.UserLoanHistoryRepository;
import com.group.libearyapp.app.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;
  private final UserLoanHistoryRepository userLoanHistoryRepository;

  public BookService(BookRepository bookRepository, UserRepository userRepository,
      UserLoanHistoryRepository userLoanHistoryRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
    this.userLoanHistoryRepository = userLoanHistoryRepository;
  }

  @Transactional
  public void saveBook(CreateBookRequest request) {
    bookRepository.save(new Book(request.getName()));
  }

  @Transactional
  public void loanBook(BookLoanRequest request) {
    User user = userRepository.findByName(request.getUserName());
    if (user == null) {
      throw new IllegalArgumentException();
    }

    Book book = bookRepository.findByName(request.getBookName())
        .orElseThrow(IllegalArgumentException::new);

    boolean isReturn = userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false);
    if (isReturn) {
      throw new IllegalArgumentException("현재 대출중인 도서 입니다.");
    }
    user.loanBook(request.getBookName());
//UserLoanHistory userLoanHistory = new UserLoanHistory(user.getId(), book.getName(), false);
//    userLoanHistoryRepository.save(loan(user, book.getName()));
  }

  @Transactional
  public void returnBook(BookReturnRequest request) {
    User user = userRepository.findByName(request.getUserName());
    if (user == null) {
      throw new IllegalArgumentException();
    }
    user.returnBook(request.getBookName());
  }
}
