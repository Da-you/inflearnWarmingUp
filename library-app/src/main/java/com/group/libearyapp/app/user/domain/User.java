package com.group.libearyapp.app.user.domain;

import com.group.libearyapp.app.user.domain.loanhistory.UserLoanHistory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer age;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserLoanHistory> histories = new ArrayList<>();

  protected User() {
    // 접근제어자는 가급적 최소한의 범위만 열어둔다.
    //. JPA 스펙이 요구하는 사항 중 하나가,
    // Entity(엔티티) 클래스가 프록시화될 수 있도록 하기 위해 기본 생성자를 최소 protected 접근제어자로 설정하는 것입니다
  }

  public User(String name, Integer age) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("이름은 필수값 입니다.");
    }
    this.name = name;
    this.age = age;
  }


  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public void loanBook(String bookName) {
    this.histories.add(new UserLoanHistory(this, bookName, false));
  }

  public void returnBook(String bookName) {
    UserLoanHistory book = this.histories.stream()
        .filter(userLoanHistory -> userLoanHistory.getBookName().equals(bookName))
        .findFirst().orElseThrow(IllegalArgumentException::new);
    book.doReturn();
  }
}
