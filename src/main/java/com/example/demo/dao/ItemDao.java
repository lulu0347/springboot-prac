package com.example.demo.dao;

import java.util.List;

import com.example.demo.constant.ItemKind;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

public interface ItemDao {

	List<Item> getItems(ItemKind itemKind, String search_keyWord);//取得所有商品
	
	Item getItemById(Integer itemId);
	
	Integer createItem(ItemRequest itemRequest);
	
	void updateItem(ItemRequest itemRequest, Integer itemNo);
	
	void deleteItemById(Integer itemNo);
}
