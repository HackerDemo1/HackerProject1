package com.hackerproject.repo;

import org.springframework.data.repository.CrudRepository;

import com.hackerproject.controller.Users;

public interface UsersRepo extends CrudRepository<Users, String> {
	
	public Users findOneByusername(String username);

}
