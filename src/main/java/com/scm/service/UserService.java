package com.scm.service;

import java.util.List;
import java.util.Optional;

import com.scm.entity.User;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String userId);
    User updateUser(User user);
    void deleteUser(String userId);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers();
}
