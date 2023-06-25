package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemQueryParameters;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	// 與分頁版共用方法
	public List<Item> getItems(ItemQueryParameters itemQueryParameters) {
		return itemDao.getItems(itemQueryParameters);
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

	@Override
	public Integer countItem(ItemQueryParameters itemQueryParameters) {
		return itemDao.countItem(itemQueryParameters);
	}
}
