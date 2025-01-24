package com.eSun.votingSystem.dto;

import com.eSun.votingSystem.dao.VoteItemsDao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteItemsDto {
	
	private Integer id;
	private String itemName;
	
	public VoteItemsDto(Integer id, String itemName) {
		this.id = id;
		this.itemName = itemName;
	}
	
	public VoteItemsDto(VoteItemsDao item) {
		this.id = item.getId();
		this.itemName = item.getItemName();
	}

}
