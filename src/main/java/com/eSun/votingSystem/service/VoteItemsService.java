package com.eSun.votingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.dao.VoteItemsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoteItemsService {

	@Autowired
	private VoteItemsRepository itemsRepo;
	
	public VoteItemsDao saveItem(VoteItemsDao item) {
		
		return itemsRepo.save(item);
	}
	
	public VoteItemsDao findById(Integer id) {
		Optional<VoteItemsDao> optional = itemsRepo.findById(id);
		
		if(optional.isPresent()) {
			VoteItemsDao itemDao = optional.get();
			return itemDao;
		}
		return null;
	}
	
	public List<VoteItemsDao> findAll() {
		return itemsRepo.findAll();
	}
	
	public boolean updateItemDetail(VoteItemsDao item) {
		
		Optional<VoteItemsDao> optional = itemsRepo.findById(item.getId());
		
		if(optional.isPresent()) {
			VoteItemsDao itemFromDB = optional.get();
			itemFromDB.setItemName(item.getItemName());
			itemsRepo.save(itemFromDB);
			return true;
		}
		
		return false;
	}
	
	public void deleteItemById(Integer id) {
		itemsRepo.deleteById(id);
	}
	
}
