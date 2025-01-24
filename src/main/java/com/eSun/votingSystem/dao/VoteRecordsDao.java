package com.eSun.votingSystem.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vote_records")
public class VoteRecordsDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "voter_name", nullable = false)
	private String voterName;
	
	@Column(name = "vote_item", nullable = false, insertable = false, updatable = false)
	private Integer voteItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vote_item")
	@JsonBackReference
	private VoteItemsDao voteItemsDao;
}
