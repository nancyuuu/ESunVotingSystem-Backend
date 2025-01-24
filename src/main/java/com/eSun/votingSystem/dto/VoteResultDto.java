package com.eSun.votingSystem.dto;

import com.eSun.votingSystem.dao.VoteItemsDao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteResultDto {
	private Integer id;
	private String itemName;
	private int voteNum;
	
	public VoteResultDto(VoteItemsDao item) {
		this.id = item.getId();
		this.itemName = item.getItemName();
		
		if (item.getVoteRecords() == null) {
			this.voteNum = 0;
			
		} else {
			this.voteNum = item.getVoteRecords().size();
		}
	}
}
