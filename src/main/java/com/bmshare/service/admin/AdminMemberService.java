package com.bmshare.service.admin;

import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmshare.jpa.entity.Member;
import com.bmshare.jpa.repository.GradeRepository;
import com.bmshare.jpa.repository.MemberRepository;
import com.bmshare.vo.admin.AdminMemberInsertReqVo;
import com.bmshare.vo.admin.AdminMemberUpsertReqVo;

@Service
public class AdminMemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	public List<Member> findAll() {
		return memberRepository.findAll();
	}
	
	public Member findBySq(Long sq) {
		return memberRepository.findBySq(sq);
	}
	
	@Transactional
	public Member insert(AdminMemberInsertReqVo reqVo) {
		Member member = new Member();
		BeanUtils.copyProperties(reqVo, member);
		
		member.setGrade(gradeRepository.findByName("LEVEL 1"));
		
		return memberRepository.save(member);
	}

	@Transactional
	public Member update(Long sq, AdminMemberUpsertReqVo reqVo) {
		Member member = memberRepository.findBySq(sq);
		
		BeanUtils.copyProperties(reqVo, member, getNullPropertyNames(reqVo));
		
		return memberRepository.save(member);
	}
	
	public static String[] getNullPropertyNames(Object source) {
	    final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
	    return Stream.of(wrappedSource.getPropertyDescriptors())
	            .map(FeatureDescriptor::getName)
	            .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
	            .toArray(String[]::new);
	}
}
