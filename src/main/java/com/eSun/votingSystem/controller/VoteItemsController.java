package com.eSun.votingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.service.VoteItemsService;

@RestController
public class VoteItemsController {

	@Autowired
	private VoteItemsService itemService;
	
	@PostMapping("/voteItem")
	public VoteItemsDao addVoteItem(@RequestBody VoteItemsDao itemInfo) {
		return itemService.saveItem(itemInfo);
	}
	
	@GetMapping("/voteItem/{itemId}")
	public VoteItemsDao showVoteItem(@PathVariable("itemId") Integer id) {
		return itemService.findById(id);
	}
	
	@GetMapping("/voteItem")
	public List<VoteItemsDao> showAllVoteItem() {
		return itemService.findAll();
	}
	
	@PutMapping("/voteItem")
	public String editItem(@RequestBody VoteItemsDao item) {
		boolean updateItem = itemService.updateItemDetail(item);
		if(updateItem) {
			return "update success";
		}
		return "update failed";
	}
	
	@DeleteMapping("/voteItem/{itemId}")
	public String deleteItem(@PathVariable("itemId") Integer id) {
		VoteItemsDao itemsDao = itemService.findById(id);
		
		if(itemsDao != null) {
			itemService.deleteItemById(id);
			return "delete success";
		}
		return "delete failed";
	}
}
