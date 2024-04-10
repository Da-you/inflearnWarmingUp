package com.group.libearyapp.app.user.service;

import com.group.libearyapp.app.user.domain.User;
import com.group.libearyapp.app.user.repository.UserRepository;
import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.request.UserUpdateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceV2 {

  private final UserRepository userRepository;

  public UserServiceV2(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void saveUser(UserCreateRequest request) {
    userRepository.save(new User(request.getName(), request.getAge()));
  }

  @Transactional(readOnly = true)
  public List<UserResponse> getUsers() {
//    return userRepository.findAll().stream()
//        .map(user -> new UserResponse(user.getId(), user.getName(),
//            user.getAge()))
//        .collect(Collectors.toList());
    return userRepository.findAll().stream()
        .map(UserResponse::new).collect(Collectors.toList());
  }

  @Transactional
  public void updateUser(UserUpdateRequest request) {
    User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);

    user.updateName(request.getName());
    /*
    트랜잭션의 변경감지 dirty check로 save하지 않아도 적용하여 update 쿼리 발생
     */
//    userRepository.save(user);
  }

  @Transactional
  public void deleteUser(String name) {
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new IllegalArgumentException();
    }
    userRepository.delete(user);
  }
}
