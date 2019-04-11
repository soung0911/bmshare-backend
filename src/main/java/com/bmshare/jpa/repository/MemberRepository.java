package com.bmshare.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmshare.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	public Member findBySq(Long sq);
}
