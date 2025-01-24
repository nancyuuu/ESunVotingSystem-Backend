package com.eSun.votingSystem.dao;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vote_items")
public class VoteItemsDao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "item_name", nullable = false)
	private String itemName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voteItemsDao", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<VoteRecordsDao> voteRecords;
}
