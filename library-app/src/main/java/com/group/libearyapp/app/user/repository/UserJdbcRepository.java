package com.group.libearyapp.app.user.repository;

import com.group.libearyapp.app.user.response.UserResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // @Repository, @Service 같은 어노테이션은 개발자가 직접만든 클래스를 빈으로 등록할때 사용한다.
public class UserJdbcRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public boolean isUserNotExist(Long id) {
    // 기존에 있던 dto가 아닌 특정 필드를 사용하는 이유는 dto의 모든 필드를 사용하는 것이 아니게 특정 필드로 변경
    String readSql = "select * from user where id = ?";
    // req의 id를 받아 db를 조회 해당 id를 가진 유저가 있다면 0이 담긴 list반환 없다면 빈 list를 반환
    return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id)
        .isEmpty();
  }

  public void updateUsername(String name, Long id) {
    String sql = "update user set name = ? where id = ? ";
    jdbcTemplate.update(sql, name, id);
  }

  public boolean isUserNotExist(String name) {
    String readSql = "select * from user where name = ?";
    // req의 id를 받아 db를 조회 해당 id를 가진 유저가 있다면 0이 담긴 list반환 없다면 빈 list를 반환
    return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
  }

  public void deleteUser(String name) {
    String sql = "delete from user where name = ?";
    jdbcTemplate.update(sql, name);
  }

  public void saveUser(String name, Integer age) {
    String sql = "insert into user (name,age) values(?,?)";
    jdbcTemplate.update(sql, name, age);
  }
  public List<UserResponse> getUsers(){
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
}
