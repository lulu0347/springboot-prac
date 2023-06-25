package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ItemQueryParameters;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

public interface ItemService {

	// 與分頁版共用方法
	List<Item> getItems(ItemQueryParameters itemQueryParameters); 
	
	Item getItemById(Integer itemId);
	
	Integer createItem(ItemRequest itemRequest);
	
	void updateItem(ItemRequest itemRequest, Integer itemNo);
	
	void deleteItemById(Integer itemNo);

	Integer countItem(ItemQueryParameters itemQueryParameters);
	
}
