package com.example.demo.service;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

public interface ItemService {

	Item getItemById(Integer itemId);
	
	Integer createItem(ItemRequest itemRequest);
}
