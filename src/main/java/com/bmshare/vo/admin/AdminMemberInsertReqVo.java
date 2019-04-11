package com.bmshare.vo.admin;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminMemberInsertReqVo {
	@NotNull
	@ApiModelProperty(required = true)
	private String id;
	
	@NotNull
	@ApiModelProperty(required = true)
	private String password;
	
	@NotNull
	@ApiModelProperty(required = true)
	private String name;
	
	@NotNull
	@ApiModelProperty(required = true)
	private String phone;
	
	@NotNull
	@ApiModelProperty(required = true)
	private String email;
	
	@NotNull
	@ApiModelProperty(required = true)
	private LocalDate birthday;
	
	@ApiModelProperty(required = false)
	private String image;
	
	@ApiModelProperty(required = false)
	private String sex;
	
	@NotNull
	@ApiModelProperty(required = true)
	private String nickname;
}
