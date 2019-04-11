package com.bmshare.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="t_member")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sq;
	
	private String id;
	
	private String password;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String image;
	
	private String sex;
	
	private String nickname;
	
	private LocalDate birthday;
	
	@CreationTimestamp
	private LocalDateTime createdDatetime;
	
	@UpdateTimestamp
	private LocalDateTime updatedDatetime;
	
	@ManyToOne
	@JoinColumn(name="grade_sq", referencedColumnName="sq")
	private Grade grade;
	
	private int point;
}
