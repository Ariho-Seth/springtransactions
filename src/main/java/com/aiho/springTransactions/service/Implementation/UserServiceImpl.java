package com.aiho.springTransactions.service.Implementation;

import com.aiho.springTransactions.domain.Users;
import com.aiho.springTransactions.payLoad.UserPayLoad;
import com.aiho.springTransactions.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<Users> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();

        users.add(new Users(1L, "Ariho", "Seth", "arihoseth@gmail.com", "seth32"));
        users.add(new Users(2L, "Ainom", "Ishma", "ainomishma@gmail.com", "Ishma32"));
    }

    @Override
    public List<Users> getAllUsers() {
        return users;
    }

    @Override
    public Users getUser(long userId) {
        return users.stream().filter(u-> u.getId() == userId).findFirst().orElseThrow();
    }

    @Override
    public Users createUser(UserPayLoad userPayLoad) {
        long userId = users.stream().max(Comparator.comparing(Users::getId)).map(Users::getId).orElse(0L);



        Users user= new Users(userId+ 1, userPayLoad.getFirstName(),  userPayLoad.getLastName(), userPayLoad.getEmail(), userPayLoad.getPassword());
            users.add(user);
            return user;
    }
}
