package com.group.libearyapp.app.user.repository;

import com.group.libearyapp.app.user.domain.loanhistory.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

  boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

}
