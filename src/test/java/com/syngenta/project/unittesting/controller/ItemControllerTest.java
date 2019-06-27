package com.syngenta.project.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.syngenta.project.unittesting.buisness.ItemBuisnessService;
import com.syngenta.project.unittesting.model.Item;

/**
 * This test class is to test a controller
 * put the name of the controller inside the {@link WebMvcTest} value
 * Get the instance of MockMvc and perform the desired request using the perform function
 * @author s982525
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBuisnessService buisnessService;
	
	
	@Test
	public void dummyItemTest() throws Exception{
		
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"price\":10,\"quantity\":100,\"name\":\"Ball\"}"))
 				.andReturn();
	}
	
	@Test
	public void getItemUsingServiceTest() throws Exception{
		
		when(buisnessService.retriveItem()).thenReturn(new Item(2, "Hair Oil", 50, 100));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:\"Hair Oil\",price:50,quantity:100}"))
 				.andReturn();
	}
	
	@Test
	public void getAllItemTest() throws Exception {
		List<Item> arrayList = new ArrayList<>();
		arrayList.add(new Item(2, "Hair Oil", 50, 100));
		when(buisnessService.getAllItems()).thenReturn(arrayList);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/items")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"name\":\"Hair Oil\",\"price\":50,\"quantity\":100}]"))
 				.andReturn();
	}
}
