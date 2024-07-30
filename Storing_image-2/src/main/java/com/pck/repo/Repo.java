package com.pck.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pck.entity.UserEntity;

//import com.pck.entity.Entity;
//import com.pck.entity.userEntity;

@Repository
public interface Repo extends JpaRepository<UserEntity, Integer> {

}
