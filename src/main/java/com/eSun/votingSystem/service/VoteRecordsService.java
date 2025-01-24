package com.eSun.votingSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.dao.VoteRecordsDao;
import com.eSun.votingSystem.dto.VoteResultDto;
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
	
	public List<VoteResultDto> showAllResult() {
		List<VoteItemsDao> items = itemsRepo.findAll();
		return items.stream()
				.map(item -> new VoteResultDto(item))
				.collect(Collectors.toList());
	}
}
