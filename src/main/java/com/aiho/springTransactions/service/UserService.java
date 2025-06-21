package com.aiho.springTransactions.service;

import com.aiho.springTransactions.domain.Users;
import com.aiho.springTransactions.payLoad.UserPayLoad;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    Users getUser(long id);

    Users createUser(UserPayLoad userPayLoad);
}
