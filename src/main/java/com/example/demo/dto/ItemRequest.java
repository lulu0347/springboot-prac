package com.example.demo.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.example.demo.constant.ItemKind;

public class ItemRequest {

	//接JSON格式的數據
	
	@NotNull
	private Integer kindNo;
	
	@NotNull
	private String itemName;
	
	@NotNull
	private Integer itemPrice;
	
	@NotNull
	private Integer itemState;
	
	@NotNull
	private BigDecimal warrantyDate;
	
	@NotNull
	private String itemProdDescription;
	
	private ItemKind itemKind;//Enum類型
	
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
	public ItemKind getItemKind() {
		return itemKind;
	}
	public void setItemKind(ItemKind itemKind) {
		this.itemKind = itemKind;
	}
}
