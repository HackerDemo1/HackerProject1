package com.hackerproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hackerproject.controller.Users;
import com.hackerproject.repo.UsersRepo;
@Component
public class HackerUserDetail implements UserDetailsService {

	private UsersRepo repo;
	public HackerUserDetail(UsersRepo repo)
	{
		this.repo = repo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findOneByusername(username);
		System.out.println("INVOKED -->"+ user.getusername());
		List<GrantedAuthority> grantedauthorities = new ArrayList<>();
		grantedauthorities.add(new SimpleGrantedAuthority(user.getRole()));
		UserDetails userdetails = new org.springframework.security.core.userdetails.User(user.getusername(),user.getPassword(),grantedauthorities);
		return userdetails ;
		
	}

}
