package com.mohamed.cms.services;

import java.util.List;

import com.mohamed.cms.dto.FriendDTO;

public interface IFriendsService {

	FriendDTO addFriend(FriendDTO friendDto);
	
	List<FriendDTO> getFriends();
	
	FriendDTO getFriend(String friendId);
	
	void deleteFriend(String friendId);
}
