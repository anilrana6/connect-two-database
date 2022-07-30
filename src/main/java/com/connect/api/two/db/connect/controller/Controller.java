package com.connect.api.two.db.connect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connect.api.two.db.connect.PrimEntity.Users;
import com.connect.api.two.db.connect.secEntity.Manager;
import com.connect.api.two.db.connect.service.UserService;

@RestController
@RequestMapping("/twodb/v1")
public class Controller {

	@Autowired
	private UserService service;
	
	@GetMapping("/ping")
	public String ping(){
		return "running";
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<List<Users>> getAllUser(){
		
		//return new ResponseEntity<>(service.getAllUser(),HttpStatus.OK);
		return Optional.ofNullable(service.getAllUser())
				.map(response->new ResponseEntity<>(response,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable("userId") Integer userId) throws Exception{
			return Optional.ofNullable(service.getUserById(userId))
				.map(response->new ResponseEntity<>(response,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/getManager")
	public ResponseEntity<List<Manager>> getAllManager(){
		return new ResponseEntity<>(service.getAllManager(),HttpStatus.OK);
	}
}
