package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item/{itemId}")
	public ResponseEntity<Item> getItem(@PathVariable Integer itemId){
		
		Item item = itemService.getItemById(itemId);
		
		if(item != null) {
			return ResponseEntity.status(HttpStatus.OK).body(item);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/item")
	public ResponseEntity<Item> createItem(@RequestBody @Valid ItemRequest itemRequest){
		
		Integer itemNo = itemService.createItem(itemRequest);
		
		Item item = itemService.getItemById(itemNo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(item);
		
	}
	
}
