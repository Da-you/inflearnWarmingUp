package com.group.libearyapp.app.user;

import com.group.libearyapp.app.user.domain.User;
import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final List<User> users = new ArrayList<>();

  @PostMapping("/user")
  public void saveUser(@RequestBody UserCreateRequest request) {
    User user = new User(request.getName(), request.getAge());
    users.add(user);
  }

  @GetMapping("/user")
  public List<UserResponse> getUsers() {
    List<UserResponse> res = new ArrayList<>();
    for (int i = 0; i < users.size(); i++) {
      res.add(new UserResponse(i + 1L, users.get(i)));
    }
    return res;
  }
}
