package com.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data
public class menuVO {
	private String menuCode;
	private String menuName;
	private String progPath;
	private Date createDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;
}
