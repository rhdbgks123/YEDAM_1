package com.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewVO {
	private int reviewSeq;	
	private int starPoint;	
	private String reviewdetail;	
	private String reviewImageNumber;	
	private Date createDate;	
	private String createdBy;	
}
