package com.learning.springsecuritydemodur.service;

import com.learning.springsecuritydemodur.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list =new ArrayList<>();

    public UserService(){
        list.add(new User("Harshil","password","harshil@gmail.com"));
        list.add(new User("Priyanshu","password","priyanshu@gmail.com"));
    }

    public List<User> getAllUsers(){
        return this.list;
    }

    public User getUser(String username){
        return list.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
