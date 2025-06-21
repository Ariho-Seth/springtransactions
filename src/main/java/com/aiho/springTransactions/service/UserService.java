package com.aiho.springTransactions.service;

import com.aiho.springTransactions.domain.User;
import com.aiho.springTransactions.payLoad.UserPayLoad;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    User createUser(UserPayLoad userPayLoad);

    User updateUser(long id, UserPayLoad userPayLoad);

    void deleteUser(long id);
}
