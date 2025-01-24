package com.eSun.votingSystem.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.eSun.votingSystem.components.DeleteResult;
import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.components.UpdateResult;
import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.dao.VoteItemsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoteItemsService {

	@Autowired
	private VoteItemsRepository itemsRepo;
	
	public InsertResult saveItem(VoteItemsDao item) {
		try {
			itemsRepo.save(item);
			return InsertResult.SUCCESS;
			
		} catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			if (e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
				// 資料違反唯一約束
				return InsertResult.DUPLICATE;
				
			} else {
				// 其他Exception
				return InsertResult.FAILURE;
			}
		}
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
	
	public UpdateResult updateItemDetail(VoteItemsDao item) {
		
		Optional<VoteItemsDao> optional = itemsRepo.findById(item.getId());
		
		if(optional.isPresent()) {
			VoteItemsDao itemFromDB = optional.get();
			itemFromDB.setItemName(item.getItemName());
			itemsRepo.save(itemFromDB);
			return UpdateResult.SUCCESS;
		}
		
		return UpdateResult.FAILURE;
	}
	
	public DeleteResult deleteItemById(Integer id) {
		VoteItemsDao itemsDao = findById(id);
		if (itemsDao == null) {
			return DeleteResult.EMPTY;
		}
		
		try {
			itemsRepo.deleteById(id);
			return DeleteResult.SUCCESS;
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			// TODO: Exception發生原因待確認
			return DeleteResult.FAILURE;
		}
	}
	
}
