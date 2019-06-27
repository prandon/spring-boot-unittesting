package com.syngenta.project.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syngenta.project.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
