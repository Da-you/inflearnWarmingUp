package com.group.libearyapp.app.user.request;

public class UserCreateRequest {
  private String name;
  private Integer age; // null을 포함

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }
}
