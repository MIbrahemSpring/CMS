package com.mohamed.cms.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Document(collection = "friends")
public class FriendEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String friendId;
	private String name;
	private String email;
	private Integer phone;
	private String home;
	private boolean status;
	private String message;

	private FriendEntity(FriendEntityBuilder builder) {

		this.friendId = builder.friendId;
		this.name = builder.name;
		this.email = builder.email;
		this.phone = builder.phone;
		this.home = builder.home;
		this.status = builder.status;
		this.message = builder.message;
	}

	public static class FriendEntityBuilder {
		private String friendId;
		private String name;
		private String email;
		private Integer phone;
		private String home;
		private boolean status;
		private String message;


		public FriendEntityBuilder setFriendId(String friendId) {
			this.friendId = friendId;
			return this;
		}

		public FriendEntityBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public FriendEntityBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public FriendEntityBuilder setPhone(Integer phone) {
			this.phone = phone;
			return this;
		}

		public FriendEntityBuilder setHome(String home) {
			this.home = home;
			return this;
		}

		public FriendEntityBuilder setStatus(boolean status) {
			this.status = status;
			return this;
		}

		public FriendEntityBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public FriendEntity build() {
			return new FriendEntity(this);
		}

	}

}
