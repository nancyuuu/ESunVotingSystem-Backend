package com.eSun.votingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.eSun.votingSystem.dao.VoteItemsDao;
import com.eSun.votingSystem.dto.VoteItemsDto;
import com.eSun.votingSystem.response.BaseResponse;
import com.eSun.votingSystem.service.VoteItemsService;

@RestController
@CrossOrigin
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
		VoteItemsDto result = itemService.findById(id);
		
		if (result != null) {
			BaseResponse returnBody = new BaseResponse(result);
			return setQueryResponse(returnBody, QueryResult.SUCCESS);
			
		} else {
			return setQueryResponse(new BaseResponse(), QueryResult.EMPTY);
		}
		
	}
	
	@GetMapping("/voteItem")
	public BaseResponse showAllVoteItem() {
		List<VoteItemsDto> items = itemService.findAll();
		
		if (items != null && items.size() > 0) {
			BaseResponse returnBody = new BaseResponse(itemService.findAll());
			return setQueryResponse(returnBody, QueryResult.SUCCESS);
			
		} else {
			return setQueryResponse(new BaseResponse(), QueryResult.EMPTY);
		}
		
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
