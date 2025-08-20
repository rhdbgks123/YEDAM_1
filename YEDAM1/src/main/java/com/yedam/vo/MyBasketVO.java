package com.yedam.vo;

import lombok.Data;

@Data
public class MyBasketVO {
	private String userId;
	private String itemCode;
	private int itemQty;
	private String itemName;
	private int salePrice;
	private int price;
	private int deliveryPrice;
	private String itemImage;
}
