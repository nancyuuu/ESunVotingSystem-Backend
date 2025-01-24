package com.eSun.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.components.QueryResult;
import com.eSun.votingSystem.dao.BaseDao;
import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.response.BaseResponse;
import com.eSun.votingSystem.service.VoteItemsService;

@RestController
public class VoteItemsController extends BaseController {

	@Autowired
	private VoteItemsService itemService;
	
	@PostMapping("/voteItem")
	public BaseResponse addVoteItem(@RequestBody VoteItemsDao itemInfo) {
		InsertResult result = itemService.saveItem(itemInfo);
		return setInsertResponse(new BaseResponse(), result);
	}
	
	@GetMapping("/voteItem/{itemId}")
	public BaseResponse showVoteItem(@PathVariable("itemId") Integer id) {
		BaseDao result = itemService.findById(id);
		BaseResponse returnBody = new BaseResponse(result);
		return setQueryResponse(returnBody, QueryResult.SUCCESS);
	}
	
	@GetMapping("/voteItem")
	public BaseResponse showAllVoteItem() {
		BaseResponse returnBody = new BaseResponse(itemService.findAll());
		return setQueryResponse(returnBody, QueryResult.SUCCESS);
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
