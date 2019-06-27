package com.syngenta.project.unittesting.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.syngenta.project.unittesting.data.ItemRepository;
import com.syngenta.project.unittesting.model.Item;

/**
 * Test for itemRepository using the inmemory database
 * @author s982525
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findAllTest() {
		List<Item> items = repository.findAll();
		assertEquals(6, items.size());
	}
}
