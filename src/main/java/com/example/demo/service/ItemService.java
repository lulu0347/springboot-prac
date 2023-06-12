package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

public interface ItemService {

	List<Item> getItems();//取得所有商品
	
	Item getItemById(Integer itemId);
	
	Integer createItem(ItemRequest itemRequest);
	
	void updateItem(ItemRequest itemRequest, Integer itemNo);
	
	void deleteItemById(Integer itemNo);
	
}
