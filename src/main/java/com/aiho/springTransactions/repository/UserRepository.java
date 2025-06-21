package com.aiho.springTransactions.repository;

import com.aiho.springTransactions.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(long userId);

    void save(User user);

    void deleteById(long userId);
}
