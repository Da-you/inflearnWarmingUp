package com.group.libearyapp.app.user.repository;

import com.group.libearyapp.app.user.domain.loanhistory.UserLoanHistory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

  boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

  Optional<UserLoanHistory> findByUSerIdAndBookName(Long userId, String bookName);
}
