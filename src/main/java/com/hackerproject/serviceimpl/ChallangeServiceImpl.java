package com.hackerproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerproject.repo.ChallangeRepo;
import com.hackerproject.service.ChallangerService;

@Service
public class ChallangeServiceImpl implements ChallangerService {

	@Autowired
	ChallangeRepo repo;
	@Override
	public long getCount() {
		
		return repo.count();
	}

}
