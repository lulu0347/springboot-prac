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
import org.springframework.util.StringUtils;

import com.example.demo.constant.ItemKind;
import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.rowMapper.ItemRowMapper;

@Component
public class ItemDaoImpl implements ItemDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public List<Item> getItems(ItemKind itemKind, String search_keyWord) {
		
		String sql = 
				"SELECT itemNo, kindNo, "
				+ "itemName, itemprice, "
				+ "itemstate, soldtime, "
				+ "launchedtime, warrantydate, "
				+ "itemproddescription "
				+ "FROM Item "
				+ "WHERE 1=1";
		
		String kind = "";
		
		//將enum的英文轉為數字 符合item資料表內KindNo欄位數值
		if(itemKind != null) {
			switch (itemKind.name()) {
		    case "CELLPHONE":
		    	kind = "1";
		        break;
		    case "COMPUTER":
		    	kind = "2";
		        break;
		    case "WATCH":
		    	kind = "3";
		        break;
		    case "CAMERA":
		    	kind = "4";
		        break;
		    case "FITTING":
		    	kind = "5";
		        break;
			}
		}

		Map<String,Object> map = new HashMap<String,Object>();

		if(kind != null && kind.trim().length() != 0) {
			sql = sql + " AND kindNo = :kindNo ";
			map.put("kindNo", kind);
		}
		
		if(search_keyWord != null && search_keyWord.trim().length() !=0) {
			sql = sql + " AND itemName LIKE :search_keyWord ";
			map.put("search_keyWord", "%"+ search_keyWord +"%");
		}
		
		List<Item> list = namedParameterJdbcTemplate.query(sql, map, new ItemRowMapper());
		
		return list;
	}

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

	@Override
	public void updateItem(ItemRequest itemRequest, Integer itemNo) {
		
		final String sql = "UPDATE Item SET kindNo = :kindNo, itemName = :itemName, itemPrice = :itemPrice, itemState = :itemState, warrantyDate = :warrantyDate, "
				+ "itemProdDescription = :itemProdDescription, launchedTime =:launchedTime, soldTime = :soldTime "
				+ "WHERE itemNo = :itemNo";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("itemNo", itemNo);
		
		map.put("kindNo", itemRequest.getKindNo());
		map.put("itemName", itemRequest.getItemName());
		map.put("itemPrice", itemRequest.getItemPrice());
		map.put("itemState", itemRequest.getItemState());
		map.put("warrantyDate", itemRequest.getWarrantyDate());
		//切忌大小寫問題 2023-06-11 
		map.put("itemProdDescription", itemRequest.getItemProdDescription().toString());
		
		map.put("launchedTime", new Date());//註 : 這邊暫且先做強制更新
		map.put("soldTime", new Date());//註 : 這邊暫且先做強制更新
		
		namedParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public void deleteItemById(Integer itemNo) {
		
		final String sql = " DELETE FROM Item WHERE itemNo = :itemNo ";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("itemNo", itemNo);
		
		namedParameterJdbcTemplate.update(sql, map);
	}
}
