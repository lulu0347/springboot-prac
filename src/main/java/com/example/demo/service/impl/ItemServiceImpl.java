package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public Item getItemById(Integer itemId) {
		return itemDao.getItemById(itemId);
	}

	@Override
	public Integer createItem(ItemRequest itemRequest) {
		return itemDao.createItem(itemRequest);
	}

	@Override
	public void updateItem(ItemRequest itemRequest, Integer itemNo) {
		itemDao.updateItem(itemRequest, itemNo);
	}

	@Override
	public void deleteItemById(Integer itemNo) {
		itemDao.deleteItemById(itemNo);
		
	}
}
