package com.mohamed.cms.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Friend {

	@NotEmpty(message = "Please enter a name")
	private String name;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email address")
	private String email;

	@NotNull(message = "Please enter a phone number")
	private Integer phone;

	private String home;
}
