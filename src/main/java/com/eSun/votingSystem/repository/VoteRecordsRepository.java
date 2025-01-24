package com.eSun.votingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eSun.votingSystem.dao.VoteRecordsDao;

public interface VoteRecordsRepository extends JpaRepository<VoteRecordsDao, Integer>{

}
