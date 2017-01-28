package com.hackerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerproject.repo.UsersRepo;
import com.hackerproject.service.ChallangerService;

@RestController
@RequestMapping("/HACKER/")
public class Example {
	@Autowired
	ChallangerService service;
	@Autowired
	UsersRepo repo;
	
	@RequestMapping(value={"Challanges","/Oauth/Challanges"}, method=RequestMethod.GET)
	public ResponseEntity<?> demo()
	{
		
		return new ResponseEntity<>(service.getAllChallanges(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping(value={"/ChallangesDemo","/Oauth/ChallangesDemo"}, method=RequestMethod.GET)
	public ResponseEntity<?> demo1()
	{
		
		return new ResponseEntity<>(service.getAllChallanges(), HttpStatus.OK);
	}

}
