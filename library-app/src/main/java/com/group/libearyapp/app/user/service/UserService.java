package com.group.libearyapp.app.user.service;

import com.group.libearyapp.app.user.repository.UserRepository;
import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.request.UserUpdateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void updateUser(UserUpdateRequest request) {
    boolean isUserNotExist = userRepository.isUserNotExist(request.getId());
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    userRepository.updateUsername(request.getName(), request.getId());
  }

  public void deleteUser(String name) {
    boolean isUserNotExist = userRepository.isUserNotExist(name);
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    userRepository.deleteUser(name);
  }

  public void savaeUser(UserCreateRequest request) {
    userRepository.saveUser(request.getName(), request.getAge());
  }

  public List<UserResponse> getUsers() {
    return userRepository.getUsers();
  }

}
