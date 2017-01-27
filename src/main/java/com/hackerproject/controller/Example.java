package com.hackerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackerproject.repo.UsersRepo;
import com.hackerproject.service.ChallangerService;

@Controller
public class Example {
	@Autowired
	ChallangerService service;
	@Autowired
	UsersRepo repo;
	
	@RequestMapping(value={"/Challanges","/"}, method=RequestMethod.GET)
	public ResponseEntity<?> demo()
	{
		
		return new ResponseEntity<>(service.getAllChallanges(), HttpStatus.OK);
	}

}
