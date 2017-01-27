package com.hackerproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerproject.model.Challange;
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
	@Override
	public List<Challange> getAllChallanges() {
		Iterable<Challange> ch = repo.findAll();
		List<Challange> challange = new ArrayList<>();
		for(Challange i : ch)
		{
			challange.add(new Challange(i.getChallange_id(),i.getChallange_company(),i.getChallange_desc(),i.getChallange_ctc(),i.getChallange_date()));
		}
		return challange;
	}

}
