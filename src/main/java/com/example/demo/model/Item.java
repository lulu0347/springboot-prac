package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Item {
	
	private Integer itemNo;
	private Integer kindNo;
	private String itemName;
	private Integer itemPrice;
	private Integer itemState;
	private Date soldTime;
	private Date launchedTime;
	private BigDecimal warrantyDate;
	private String itemProdDescription;
	
	public Integer getItemNo() {
		return itemNo;
	}
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	public Integer getKindNo() {
		return kindNo;
	}
	public void setKindNo(Integer kindNo) {
		this.kindNo = kindNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Integer getItemState() {
		return itemState;
	}
	public void setItemState(Integer itemState) {
		this.itemState = itemState;
	}
	public Date getSoldTime() {
		return soldTime;
	}
	public void setSoldTime(Date soldTime) {
		this.soldTime = soldTime;
	}
	public Date getLaunchedTime() {
		return launchedTime;
	}
	public void setLaunchedTime(Date launchedTime) {
		this.launchedTime = launchedTime;
	}
	public BigDecimal getWarrantyDate() {
		return warrantyDate;
	}
	public void setWarrantyDate(BigDecimal warrantyDate) {
		this.warrantyDate = warrantyDate;
	}
	public String getItemProdDescription() {
		return itemProdDescription;
	}
	public void setItemProdDescription(String itemProdDescription) {
		this.itemProdDescription = itemProdDescription;
	}
	
	
	
}
