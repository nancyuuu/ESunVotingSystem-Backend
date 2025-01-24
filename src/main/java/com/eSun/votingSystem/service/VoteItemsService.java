package com.eSun.votingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eSun.votingSystem.dao.VoteItemsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoteItemsService {

	@Autowired
	private VoteItemsRepository itemsRepo;
	
	
	
	
	
}
