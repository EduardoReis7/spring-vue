package com.er.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.er.model.Friend;

@RestController
@RequestMapping("/api/twitter")
public class FriendsController {
	
	private List<Friend> friends;
	
	public FriendsController() {
		
		friends = new ArrayList<Friend>();
		friends.add( new Friend("dovigera", "Eduardo Reis"));
		friends.add( new Friend("Vitoriaklein", "Vitoria Klein"));
		friends.add( new Friend("maicolpqsim", "Maicol"));
		friends.add( new Friend("Gui_wdornelles", "Guilherme Dornelles"));
	}
	
	@GetMapping
	public List<Friend> list() {
		return friends;
	}
	
	@GetMapping("/{id}")
	public Friend get(@PathVariable String id) {
		return friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
	}
}
