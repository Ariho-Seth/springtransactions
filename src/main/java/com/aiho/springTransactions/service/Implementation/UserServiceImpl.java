package com.aiho.springTransactions.service.Implementation;

import com.aiho.springTransactions.domain.User;
import com.aiho.springTransactions.payLoad.UserPayLoad;
import com.aiho.springTransactions.repository.UserRepository;
import com.aiho.springTransactions.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(UserPayLoad userPayLoad) {


            User user= new User(userPayLoad.getId(), userPayLoad.getFirstName(),  userPayLoad.getLastName(), userPayLoad.getEmail(), userPayLoad.getPassword());
            userRepository.save(user);
            return user;
    }

    @Override
    public User updateUser(long userId, UserPayLoad userPayLoad) {
        User user= userRepository.findById(userId);

        user.setFirstName(userPayLoad.getFirstName());
        user.setLastName(userPayLoad.getLastName());
        user.setEmail(userPayLoad.getEmail());
        user.setPassword(userPayLoad.getPassword());
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }
}
