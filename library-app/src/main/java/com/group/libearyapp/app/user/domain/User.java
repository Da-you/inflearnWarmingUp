package com.group.libearyapp.app.user.domain;

public class User {

  private String name;
  private Integer age;

  public User(String name, Integer age) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("이름은 필수값 입니다.");
    }
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }
}
