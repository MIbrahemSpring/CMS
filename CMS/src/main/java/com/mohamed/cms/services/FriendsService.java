package com.mohamed.cms.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamed.cms.dto.FriendDTO;
import com.mohamed.cms.entities.FriendEntity;
import com.mohamed.cms.repositories.FriendRepository;
import com.mohamed.cms.utils.Utils;

@Service
public class FriendsService implements IFriendsService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private Utils utils;

	@Autowired
	private FriendRepository friendRepo;

	@Override
	public FriendDTO addFriend(FriendDTO friendDto) {
		FriendEntity friendEntity = modelMapper.map(friendDto, FriendEntity.class);
		friendEntity.setFriendId(utils.generateUserId(22, "friend_"));
		FriendEntity savedEntity = friendRepo.save(friendEntity);
		if (savedEntity != null) {
			savedEntity.setStatus(true);
			savedEntity.setMessage("A new friend has been added successfully");
		}
		FriendDTO storedFriendDto = modelMapper.map(savedEntity, FriendDTO.class);
		return storedFriendDto;
	}

	@Override
	public List<FriendDTO> getFriends() {
		List<FriendDTO> friendDtoList = new ArrayList<FriendDTO>();
		;
		List<FriendEntity> friendList = friendRepo.findAll();

		if (friendList == null || friendList.size() <= 0)
			return friendDtoList;

		friendList.stream().forEach(friend -> {
			FriendDTO friendDto = modelMapper.map(friend, FriendDTO.class);
			friendDtoList.add(friendDto);
		});
		return friendDtoList;
	}

	@Override
	public void deleteFriend(String friendId) {
		friendRepo.deleteByFriendId(friendId);
	}

	@Override
	public FriendDTO getFriend(String friendId) {
		FriendEntity friendEntity = friendRepo.findByFriendId(friendId);
		if (friendEntity == null)
			return new FriendDTO();

		return modelMapper.map(friendEntity, FriendDTO.class);
	}

}
