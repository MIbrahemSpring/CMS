package com.mohamed.cms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mohamed.cms.entities.FriendEntity;

@Repository
public interface FriendRepository extends MongoRepository<FriendEntity, Long> {
	void deleteByFriendId(String friendId);
	FriendEntity findByFriendId(String id);
}
