package com.syngenta.project.unittesting.buisness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syngenta.project.unittesting.data.ItemRepository;
import com.syngenta.project.unittesting.model.Item;

@Service
public class ItemBuisnessService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item retriveItem() {
		return new Item(2, "Hair Oil", 50, 100);
	}
	
	public List<Item> getAllItems(){
		List<Item> items = itemRepository.findAll();
		
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;
	}
}
