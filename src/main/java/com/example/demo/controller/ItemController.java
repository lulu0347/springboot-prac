package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItem(){
		
		List<Item> itemList = itemService.getItems();
		
		return ResponseEntity.status(HttpStatus.OK).body(itemList);
	}
	
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
		
		return ResponseEntity.status(HttpStatus.CREATED).body(item);//201
	}
	
	@PutMapping("/item/{itemNo}")
	public ResponseEntity<Item> updateItem(@RequestBody @Valid ItemRequest itemRequest, @PathVariable Integer itemNo){
		
		Item item = itemService.getItemById(itemNo);
		
		if(item == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//404
		}
		
		itemService.updateItem(itemRequest, itemNo);
		
		Item updatedItem = itemService.getItemById(itemNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedItem);//200
	}
	
	@DeleteMapping("item/{itemNo}")
	public ResponseEntity<?> deleteItemById(@PathVariable Integer itemNo){

		itemService.deleteItemById(itemNo);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//204
	}
}
