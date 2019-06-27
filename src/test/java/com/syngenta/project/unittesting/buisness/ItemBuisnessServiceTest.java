package com.syngenta.project.unittesting.buisness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.syngenta.project.unittesting.data.ItemRepository;
import com.syngenta.project.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBuisnessServiceTest {
	
	@InjectMocks
	private ItemBuisnessService buisnessService;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void getAllItemsTest() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Hair Oil", 50, 100)));
		
		List<Item> actualItems = buisnessService.getAllItems();
		
		assertEquals(5000, actualItems.get(0).getValue());
	}
}
