package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;

import rowMapper.ItemRowMapper;

@Component
public class ItemDaoImpl implements ItemDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public Item getItemById(Integer itemNo) {

		final String sql = 
				"select itemNo, kindNo, "
				+ "itemName, itemprice, "
				+ "itemstate, soldtime, "
				+ "launchedtime, warrantydate, "
				+ "itemproddescription "
				+ "From Item where itemNo = :itemNo";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("itemNo", itemNo);
		
		List<Item> list = namedParameterJdbcTemplate.query(sql, map, new ItemRowMapper());
		
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Integer createItem(ItemRequest itemRequest) {
		final String sql = "INSERT INTO item(kindNo,itemName,itemPrice,itemState, "
				+ "warrantyDate,soldTime,launchedTime,itemProdDescription) "
				+ "Values(:kindNo, :itemName, :itemPrice, :itemState, :warrantyDate, :soldTime, :launchedTime, "
				+ ":itemProdDescription )";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("kindNo", itemRequest.getKindNo());
		map.put("itemName", itemRequest.getItemName());
		map.put("itemPrice", itemRequest.getItemPrice());
		map.put("itemState", itemRequest.getItemState());
		map.put("warrantyDate", itemRequest.getWarrantyDate());
		//切忌大小寫問題 2023-06-11 
		map.put("itemProdDescription", itemRequest.getItemProdDescription().toString());
		
		Date now = new Date();
		map.put("launchedTime", now);
		map.put("soldTime", now);

		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);
		
		int itemNo = keyHolder.getKey().intValue();
		
		return itemNo;
		
	}
	
	
}
