package com.group.libearyapp.app.user.response;

import com.group.libearyapp.app.user.domain.User;

public class UserResponse {
  private Long id;
  private String name;
  private Integer age;

  public UserResponse(Long id, User user) {
    this.id = id;
    this.name = user.getName();
    this.age = user.getAge();
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
}