package com.bmshare.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="t_grade")
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sq;
	
	private String name;
	
	private Integer point;
}
