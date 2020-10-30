package com.mastek.farmertomarket.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mastek.farmertomarket.entities.Item;



public interface ItemJPADAO extends CrudRepository<Item, Integer>{

	Iterable<Item> basketItems(@Param("basketID") int basketID);

}
