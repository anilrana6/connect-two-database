package com.connect.api.two.db.connect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connect.api.two.db.connect.PrimEntity.Users;
import com.connect.api.two.db.connect.primRepo.UserRepo;
import com.connect.api.two.db.connect.secEntity.Manager;
import com.connect.api.two.db.connect.secRepo.ManagerRepo;

@Service
public class UserService {
	
  @Autowired	
  private UserRepo userRepo;
  
  @Autowired
  private ManagerRepo managerRepo;
  
  public List<Users> getAllUser(){
	  List<Users> userlist=userRepo.findAll();
	  return userlist;
  }
  
public Users getUserById(Integer userId) throws Exception{
	  Optional<Users> user=userRepo.findById(userId);
	  if(!user.isPresent()){
		 throw new Exception("No data found"); 
	  }
	  return user.get();
  }
  
  public List<Manager> getAllManager(){
	  
	  List<Manager> mgrlist=managerRepo.findAll();
	  return mgrlist;
  }

}
