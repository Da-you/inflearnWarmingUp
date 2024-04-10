package com.group.libearyapp.app.user.domain.loanhistory;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.group.libearyapp.app.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLoanHistory {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  @Column(name = "book_name", nullable = false)
  private String bookName;
  private boolean isReturn;

  protected UserLoanHistory() {
  }

  public UserLoanHistory(User user, String bookName, boolean isReturn) {
    this.user = user;
    this.bookName = bookName;
  }

  public static UserLoanHistory loan(User user, String bookName) {
    return new UserLoanHistory(user, bookName, false);

  }

  public void doReturn() {
    this.isReturn = true;
  }

  public User getUser() {
    return user;
  }

  public String getBookName() {
    return bookName;
  }

  public boolean isReturn() {
    return isReturn;
  }
}
