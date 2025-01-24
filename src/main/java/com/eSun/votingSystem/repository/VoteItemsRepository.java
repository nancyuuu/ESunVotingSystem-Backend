package com.eSun.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSun.votingSystem.dao.VoteItemsDao;

public interface VoteItemsRepository extends JpaRepository<VoteItemsDao, Integer> {

}
