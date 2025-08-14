package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private String orderNo;
	private String userId;
	private Date orderDate;
}
