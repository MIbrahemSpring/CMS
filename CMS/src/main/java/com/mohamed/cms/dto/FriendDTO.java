package com.mohamed.cms.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FriendDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String friendId;
	private String name;
	private String email;
	private Integer phone;
	private String home;
	private boolean status;
	private String message;

}
