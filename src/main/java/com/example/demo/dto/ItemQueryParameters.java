package com.example.demo.dto;

import com.example.demo.constant.ItemKind;

public class ItemQueryParameters {

	private ItemKind itemKind;
	private String search_keyWord;
	private String orderBy;
	private String sort;
	
	public ItemKind getItemKind() {
		return itemKind;
	}
	public void setItemKind(ItemKind itemKind) {
		this.itemKind = itemKind;
	}
	public String getSearch_keyWord() {
		return search_keyWord;
	}
	public void setSearch_keyWord(String search_keyWord) {
		this.search_keyWord = search_keyWord;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
