package com.bmshare.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmshare.jpa.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
	public Grade findBySq(Long sq);
	public Grade findByName(String name);
}
