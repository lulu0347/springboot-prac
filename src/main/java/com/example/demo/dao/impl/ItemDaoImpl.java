package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ItemDao;
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
}
