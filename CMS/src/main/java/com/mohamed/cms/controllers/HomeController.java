package com.mohamed.cms.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mohamed.cms.dto.FriendDTO;
import com.mohamed.cms.entities.FriendEntity;
import com.mohamed.cms.models.Friend;
import com.mohamed.cms.repositories.FriendRepository;
import com.mohamed.cms.services.IFriendsService;

@Controller
@RequestMapping("/")
public class HomeController implements WebMvcConfigurer {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IFriendsService _friendService;
	
	@Autowired
	private FriendRepository friendRepo;

	@GetMapping
	public String getHome() {
		return "index";
	}

	@GetMapping("/phonebook")
	public String showForm(Model model) {
		model.addAttribute("friend", new Friend());
		List<FriendDTO> friends = _friendService.getFriends();
		model.addAttribute("friends", friends);
		return "phonebook";
	}

	@GetMapping("/phonebook/add")
	public String showFriendList(Model model) {
		model.addAttribute("friend", new Friend());
		List<FriendDTO> friends = _friendService.getFriends();
		model.addAttribute("friends", friends);
		return "add-form";
	}

	@PostMapping("/phonebook/add/processForm")
	public String getdashboard(@Valid Friend friend, BindingResult result, Model model) {
		if (result.hasErrors())
			return "add-form";

		FriendDTO friendDto = modelMapper.map(friend, FriendDTO.class);
		FriendDTO storedFriend = _friendService.addFriend(friendDto);
		friend = new Friend();
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put("status", storedFriend.isStatus());
		attrs.put("message", storedFriend.getMessage());
		attrs.put("friend", friend);
		model.addAllAttributes(attrs);
		
		return "add-form";
	}
	
	@GetMapping("/phonebook/deleteFriend/{id}")
	public String deleteFriend(@PathVariable("id") String id) {
		_friendService.deleteFriend(id);
		return "redirect:/phonebook";
	}
	
	@GetMapping("/phonebook/update/{friendId}")
	public String updateFriend(@PathVariable("friendId") String friendId, Model model) {
		FriendDTO friendDto = _friendService.getFriend(friendId);
		model.addAttribute("friend", friendDto);
		return "update-form";
	}
	
	@PostMapping("/phonebook/update")
	public String updateFriend(FriendDTO friend, BindingResult result, Model model) {
		FriendEntity dd = friendRepo.findByFriendId(friend.getFriendId());
		dd.setName(friend.getName());
		friendRepo.save(dd);
		String id = friend.getFriendId();
		return "redirect:/phonebook/update/id";
	}
	
}
