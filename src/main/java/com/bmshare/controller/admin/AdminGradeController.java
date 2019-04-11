package com.bmshare.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmshare.jpa.entity.Grade;
import com.bmshare.service.admin.AdminGradeService;
import com.bmshare.vo.admin.AdminGradeInsertReqVo;
import com.bmshare.vo.admin.AdminGradeUpsertReqVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin/v1.0/grade")
@Api(tags = "GRADE")
public class AdminGradeController {
	
	@Autowired
	AdminGradeService adminGradeService;
	
	@GetMapping
	@ApiOperation(value = "등급 조회", response = List.class)
	public ResponseEntity<Object> searchGrade() {
		return ResponseEntity.status(HttpStatus.OK).body(adminGradeService.findAll());
	}
	
	@GetMapping("/{gradeSq}")
	@ApiOperation(value = "등급 검색", response = Grade.class)
	public ResponseEntity<Object> getGrade(@PathVariable("gradeSq") Long sq) {
		return ResponseEntity.status(HttpStatus.OK).body(adminGradeService.findBySq(sq));
	}
	
	@PostMapping
	@ApiOperation(value = "등급 추가", response = Grade.class)
	public ResponseEntity<Object> insert(@RequestBody @Valid AdminGradeInsertReqVo body) {
		return ResponseEntity.status(HttpStatus.OK).body(adminGradeService.insert(body));
	}
	
	@PutMapping("/{gradeSq}")
	@ApiOperation(value = "등급 수정", response = Grade.class)
	public ResponseEntity<Object> update(@PathVariable("gradeSq") Long sq,
										@RequestBody @Valid AdminGradeUpsertReqVo body) {
		return ResponseEntity.status(HttpStatus.OK).body(adminGradeService.update(sq, body));
	}
	
}
