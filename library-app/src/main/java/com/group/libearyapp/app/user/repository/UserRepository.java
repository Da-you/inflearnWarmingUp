package com.group.libearyapp.app.user.repository;

import com.group.libearyapp.app.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);
}
