package com.bmshare.vo.admin;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminMemberUpsertReqVo {
	@ApiModelProperty(required = false)
	private String password;
	
	@ApiModelProperty(required = false)
	private String name;
	
	@ApiModelProperty(required = false)
	private String phone;
	
	@ApiModelProperty(required = false)
	private String email;
	
	@ApiModelProperty(required = false)
	private LocalDate birthday;
	
	@ApiModelProperty(required = false)
	private String image;
	
	@ApiModelProperty(required = false)
	private String sex;
	
	@ApiModelProperty(required = false)
	private String nickname;
}
