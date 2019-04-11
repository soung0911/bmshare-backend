package com.bmshare.service.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmshare.jpa.entity.Grade;
import com.bmshare.jpa.repository.GradeRepository;
import com.bmshare.vo.admin.AdminGradeInsertReqVo;
import com.bmshare.vo.admin.AdminGradeUpsertReqVo;

@Service
public class AdminGradeService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}
	
	public Grade findBySq(Long sq) {
		return gradeRepository.findBySq(sq);
	}
	
	@Transactional
	public Grade insert(AdminGradeInsertReqVo reqVo) {
		Grade grade = new Grade();
		BeanUtils.copyProperties(reqVo, grade);
		
		return gradeRepository.save(grade);
	}
	
	@Transactional
	public Grade update(Long sq, AdminGradeUpsertReqVo reqVo) {
		Grade grade = gradeRepository.findBySq(sq);
		BeanUtils.copyProperties(reqVo, grade);
		
		return gradeRepository.save(grade);
	}
}
