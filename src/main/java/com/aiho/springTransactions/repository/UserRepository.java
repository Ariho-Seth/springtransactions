package com.aiho.springTransactions.repository;

import com.aiho.springTransactions.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
