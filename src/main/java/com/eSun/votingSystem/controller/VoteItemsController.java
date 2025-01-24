package com.eSun.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eSun.votingSystem.components.DeleteResult;
import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.components.QueryResult;
import com.eSun.votingSystem.components.UpdateResult;
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
		InsertResult resultType = itemService.saveItem(itemInfo);
		
		return setInsertResponse(new BaseResponse(), resultType);
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
	public BaseResponse editItem(@RequestBody VoteItemsDao item) {
		UpdateResult resultType = itemService.updateItemDetail(item);
		
		return setUpdateResponse(new BaseResponse(), resultType);
	}
	
	@DeleteMapping("/voteItem/{itemId}")
	public BaseResponse deleteItem(@PathVariable("itemId") Integer id) {
		DeleteResult resultType = itemService.deleteItemById(id);
		
		return setDeleteResponse(new BaseResponse(), resultType);
	}
}
