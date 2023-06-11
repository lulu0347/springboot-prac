package com.example.demo.dao;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

public interface ItemDao {

	Item getItemById(Integer itemId);
	
	Integer createItem(ItemRequest itemRequest);
}
