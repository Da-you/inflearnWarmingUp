package com.group.libearyapp.app.user;

import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.request.UserUpdateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import com.group.libearyapp.app.user.service.UserService;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  //  private final List<User> users = new ArrayList<>();
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  //  @PostMapping("/user")
//  public void saveUser(@RequestBody UserCreateRequest request) {
//    User user = new User(request.getName(), request.getAge());
//    users.add(user);
//  }
  @PostMapping("/user")
  public void saveUserV2(@RequestBody UserCreateRequest request) {
    userService.savaeUser(request);
  }

  //  @GetMapping("/user")
//  public List<UserResponse> getUsers() {
//    List<UserResponse> res = new ArrayList<>();
//    for (int i = 0; i < users.size(); i++) {
//      res.add(new UserResponse(i + 1L, users.get(i)));
//    }
//    return res;
//  }
  @GetMapping("/user")
  public List<UserResponse> getUsersV2() {
    return userService.getUsers();
  }

  @PutMapping("/user")
  public void updateUser(@RequestBody UserUpdateRequest request) {
    userService.updateUser(request);
  }

  @DeleteMapping("/user")
  public void deleteUser(@RequestParam String name) {
    userService.deleteUser(name);
  }

}