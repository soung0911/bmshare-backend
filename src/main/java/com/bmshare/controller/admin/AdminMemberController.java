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

import com.bmshare.jpa.entity.Member;
import com.bmshare.service.admin.AdminMemberService;
import com.bmshare.vo.admin.AdminMemberInsertReqVo;
import com.bmshare.vo.admin.AdminMemberUpsertReqVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin/v1.0/member")
@Api(tags = "MEMBER")
public class AdminMemberController {
	
	@Autowired
	AdminMemberService adminMemberService;
	
	@GetMapping
	@ApiOperation(value = "사용자 조회", response = List.class)
	public ResponseEntity<Object> searchMember() {
		return ResponseEntity.status(HttpStatus.OK).body(adminMemberService.findAll());
	}
	
	@GetMapping("/{memberSq}")
	@ApiOperation(value = "사용자 검색", response = Member.class)
	public ResponseEntity<Object> getMember(@PathVariable("memberSq") Long sq) {
		return ResponseEntity.status(HttpStatus.OK).body(adminMemberService.findBySq(sq));
	}
	
	@PostMapping
	@ApiOperation(value = "사용자 추가", response = Member.class)
	public ResponseEntity<Object> insert(@RequestBody @Valid AdminMemberInsertReqVo body) {
		return ResponseEntity.status(HttpStatus.OK).body(adminMemberService.insert(body));
	}
	
	@PutMapping("/{memberSq}")
	@ApiOperation(value = "사용자 수정", response = Member.class)
	public ResponseEntity<Object> update(@PathVariable("memberSq") Long sq,
										@RequestBody @Valid AdminMemberUpsertReqVo body) {
		return ResponseEntity.status(HttpStatus.OK).body(adminMemberService.update(sq, body));
	}
	
}
