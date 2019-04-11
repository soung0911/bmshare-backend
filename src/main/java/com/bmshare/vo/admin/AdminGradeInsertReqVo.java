package com.bmshare.vo.admin;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminGradeInsertReqVo {
	@NotNull
	@ApiModelProperty(required = true)
	private String name;
	
	@ApiModelProperty(required = false)
	private Integer point;
}
