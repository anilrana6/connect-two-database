package com.connect.api.two.db.connect.primRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connect.api.two.db.connect.PrimEntity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

}
