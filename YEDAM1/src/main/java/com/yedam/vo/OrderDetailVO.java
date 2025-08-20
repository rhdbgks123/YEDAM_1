package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String orderNo;
	private int orderDetailNo;
	private String itemCode;
	private int itemQty;
	private int itemPrice;
	private String itemName;
	private Date orderDate;
	private String itemImage;
}
