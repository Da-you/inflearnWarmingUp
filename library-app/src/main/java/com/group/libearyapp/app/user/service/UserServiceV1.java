package com.group.libearyapp.app.user.service;

import com.group.libearyapp.app.user.repository.UserJdbcRepository;
import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.request.UserUpdateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV1 {

  private final UserJdbcRepository userJdbcRepository;

  public UserServiceV1(UserJdbcRepository userJdbcRepository) {
    this.userJdbcRepository = userJdbcRepository;
  }

  public void updateUser(UserUpdateRequest request) {
    boolean isUserNotExist = userJdbcRepository.isUserNotExist(request.getId());
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    userJdbcRepository.updateUsername(request.getName(), request.getId());
  }

  public void deleteUser(String name) {
    boolean isUserNotExist = userJdbcRepository.isUserNotExist(name);
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    userJdbcRepository.deleteUser(name);
  }

  public void savaeUser(UserCreateRequest request) {
    userJdbcRepository.saveUser(request.getName(), request.getAge());
  }

  public List<UserResponse> getUsers() {
    return userJdbcRepository.getUsers();
  }

}
