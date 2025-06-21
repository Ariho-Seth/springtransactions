package com.aiho.springTransactions.repository.Implementation;

import com.aiho.springTransactions.domain.User;
import com.aiho.springTransactions.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users;

    public UserRepositoryImpl(List<User> users) {
        this.users = new ArrayList<>();

//        users.add(new User(1L, "Aria", "Seth", "arihoseth@gmail.com", "seth32"));
//        users.add(new User(2L, "Aino", "Ishmael", "ainomishma@gmail.com", "Ishmael32"));
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User findById(long userId) {
        User user = users.stream().filter(u-> u.getId()== userId).findFirst().orElseThrow();
        return user;
    }

    @Override
    public void save(User user) {
        long userId = (this.users.stream()
                        .mapToLong(User::getId)
                        .max()
                        .orElse(0)) +1;

        user.setId(userId);
        users.add(user);


    }

    @Override
    public void deleteById(long userId) {
        User user = findById(userId);
        users.remove(user);
    }
}
