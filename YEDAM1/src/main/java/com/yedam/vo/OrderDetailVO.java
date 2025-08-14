package com.yedam.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String orderNo;
	private int orderDetailNo;
	private String itemCode;
	private int itemQty;
	private int itemPrice;
}
