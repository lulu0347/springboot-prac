package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest{

	@Autowired
	private MockMvc mockMvc;
	
	//查詢商品
	@Test
	public void getItem_suscess() throws Exception {
		
	}
	
	@Test
	public void getItem_notFound() throws Exception {
		
	}
	
	//新增商品
	@Transactional
	@Test
	public void createItem_success() throws Exception {
		
	}
	
	@Test
	@Transactional
	public void createItem_illegalArgument() throws Exception {
		
	}
	
	//更新商品
	@Transactional
	@Test
	public void updateItem_success() throws Exception {
		
	}
	
	@Test
	@Transactional
	public void updateItem_illegalArgument() throws Exception {
		
	}	
	
	@Test
	@Transactional
	public void updateItem_itemNotFound() throws Exception {
		
	}	
	
	//刪除商品
	@Transactional
	@Test
	public void deleteItem_success() throws Exception {
		
	}
	
	@Test
	@Transactional
	public void deleteItem_itemNonExsit() throws Exception {
		
	}	
	
	//查詢商品列表
	@Test
	public void getItems() throws Exception {
		
	}
	
	@Test
	public void getItems_filtering() throws Exception {
		
	}
	
	@Test
	public void getItems_sorting() throws Exception {
		
	}
	
	@Test
	public void getItems_pagination() throws Exception {
		
	}
	
}
