package com.example.demo.services.impl;

import org.springframework.stereotype.Service;

import com.example.demo.domain.BaseServiceImpl;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository, User.class);
        this.userRepository = userRepository;
    }
}
