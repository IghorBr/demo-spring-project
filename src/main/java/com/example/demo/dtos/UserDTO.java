package com.example.demo.dtos;

import com.example.demo.domain.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastName;
	private String email;
	private String password;
}
