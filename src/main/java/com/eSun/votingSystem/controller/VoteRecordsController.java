package com.eSun.votingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eSun.votingSystem.components.InsertResult;
import com.eSun.votingSystem.components.QueryResult;
import com.eSun.votingSystem.dao.VoteRecordsDao;
import com.eSun.votingSystem.dto.VoteResultDto;
import com.eSun.votingSystem.response.BaseResponse;
import com.eSun.votingSystem.service.VoteRecordsService;

@RestController
@CrossOrigin
public class VoteRecordsController extends BaseController{
	
	@Autowired
	private VoteRecordsService recordsService;
	
	@PostMapping("/voteRecord")
	public BaseResponse addVoteRecord(@RequestBody VoteRecordsDao record) {
		InsertResult resultType = recordsService.saveRecord(record);
		
		return setInsertResponse(new BaseResponse(), resultType);
	}
	
	@GetMapping("/voteRecord")
	public BaseResponse showAllVoteResult() {
		List<VoteResultDto> results = recordsService.showAllResult();
		
		if (results != null && results.size() > 0) {
			BaseResponse returnBody = new BaseResponse(results);
			return setQueryResponse(returnBody, QueryResult.SUCCESS);
			
		} else {
			return setQueryResponse(new BaseResponse(), QueryResult.EMPTY);
		}
	}
}
