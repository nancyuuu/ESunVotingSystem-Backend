package com.eSun.votingSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.dao.VoteRecordsDao;
import com.eSun.votingSystem.repository.VoteItemsRepository;
import com.eSun.votingSystem.repository.VoteRecordsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoteRecordsService {
	
	@Autowired
	private VoteRecordsRepository recordsRepo;
	
	@Autowired
	private VoteItemsRepository itemsRepo;
	
	public InsertResult saveRecord(VoteRecordsDao record) {
		int itemId = record.getVoteItem();
		Optional<VoteItemsDao> optional = itemsRepo.findById(itemId);
		
		record.setVoteItemsDao(optional.get());
		recordsRepo.save(record);
		return InsertResult.SUCCESS;
	}
	
}
