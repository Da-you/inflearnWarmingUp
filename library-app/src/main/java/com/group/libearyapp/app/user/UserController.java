package com.group.libearyapp.app.user;

import com.group.libearyapp.app.user.domain.User;
import com.group.libearyapp.app.user.request.UserCreateRequest;
import com.group.libearyapp.app.user.request.UserUpdateRequest;
import com.group.libearyapp.app.user.response.UserResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
  private final JdbcTemplate jdbcTemplate;

  public UserController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  //  @PostMapping("/user")
//  public void saveUser(@RequestBody UserCreateRequest request) {
//    User user = new User(request.getName(), request.getAge());
//    users.add(user);
//  }
  @PostMapping("/user")
  public void saveUserV2(@RequestBody UserCreateRequest request) {
    String sql = "insert into user (name,age) values(?,?)";
    jdbcTemplate.update(sql, request.getName(), request.getAge());
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
    String sql = "select * from user";
    // new RowMapper<UserResponse>() 구현 익명클래스이며 람다로 변경가능
    // mapRow역할은 우리가 조회한 user의 정보를 개발자가 선언한 타입인 UserResponse으로 바꿔주는 역할
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
      Long id = rs.getLong("id");
      String name = rs.getString("name");
      Integer age = rs.getInt("age");
      return new UserResponse(id, name, age);
    });
  }

  @PutMapping("/user")
  public void updateUser(@RequestBody UserUpdateRequest request) {
    String readSql = "select * from user where id = ?";
    // req의 id를 받아 db를 조회 해당 id를 가진 유저가 있다면 0이 담긴 list반환 없다면 빈 list를 반환
    boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId())
        .isEmpty();
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    String sql = "update user set name = ? where id = ? ";
    jdbcTemplate.update(sql, request.getName(), request.getId());
  }

  @DeleteMapping("/user")
  public void deleteUser(@RequestParam String name) {
    String readSql = "select * from user where name = ?";
    // req의 id를 받아 db를 조회 해당 id를 가진 유저가 있다면 0이 담긴 list반환 없다면 빈 list를 반환
    boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    if (isUserNotExist) {
      throw new IllegalArgumentException();
    }
    String sql = "delete from user where name = ?";
    jdbcTemplate.update(sql, name);
  }

}