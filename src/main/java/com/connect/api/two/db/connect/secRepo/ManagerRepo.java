package com.connect.api.two.db.connect.secRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connect.api.two.db.connect.secEntity.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer>{

}
