package com.syngenta.project.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syngenta.project.unittesting.buisness.ItemBuisnessService;
import com.syngenta.project.unittesting.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBuisnessService buisnessService; 
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-service")
	public Item getItemUsingService() {
		return buisnessService.retriveItem();
	}
	
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return buisnessService.getAllItems();
	}
}
