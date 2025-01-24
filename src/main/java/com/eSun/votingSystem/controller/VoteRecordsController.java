package com.eSun.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.dao.VoteRecordsDao;
import com.eSun.votingSystem.response.BaseResponse;
import com.eSun.votingSystem.service.VoteRecordsService;

@RestController
public class VoteRecordsController extends BaseController{
	
	@Autowired
	private VoteRecordsService recordsService;
	
	@PostMapping("/voteRecord")
	public BaseResponse addVoteRecord(@RequestBody VoteRecordsDao record) {
		InsertResult resultType = recordsService.saveRecord(record);
		
		return setInsertResponse(new BaseResponse(), resultType);
	}
}
