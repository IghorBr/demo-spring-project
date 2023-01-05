package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BaseController;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController<User, UserDTO> {

	private final UserService userService;

	public UserController(UserService userService) {
		super(User.class, UserDTO.class);
		this.userService = userService;
	}


}
