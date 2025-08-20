package com.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewVO {
	private int reviewSeq;
	private String itemCode;
	private int starPoint;	
	private String reviewDetail;	
	private String reviewImageNumber;	
	private Date createDate;	
	private String createdBy;
	private String updatedBy;
	private String userId;
	private String title;
	private String content;
	private String image;
	private String writer;
}
