package com.example.restaurant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.model.Item;
import com.example.restaurant.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	public Optional<Item> getItemById(Long id) {
		return itemRepository.findById(id);
	}

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public Item updateItem(Item item, Long id) {
		try {
			Optional<Item> optionalItem = itemRepository.findById(id);
			if (optionalItem.isPresent()) {

				Item oldItem = optionalItem.get();
				oldItem.setName(item.getName());
				oldItem.setPrice(item.getPrice());
				return itemRepository.save(oldItem);
			} else {
				throw new RuntimeException("Food item not found with id " + id);
			}
		} catch (Exception e) {
			throw new RuntimeException("Item not found" + id, e);
		}
	}
	
	public void deleteItem(Long id) {
		try {
			Optional<Item> optionalItem = itemRepository.findById(id);
			if(optionalItem.isPresent()) {
				itemRepository.deleteById(id);
			}
			else {
				throw new RuntimeException("item not found"+id);
			}
		}
		catch(Exception e) {
			throw new RuntimeException("unable to delete" + id, e);
		}
	}
	
	public List<Item> addMultipleItems(List<Item> items){
		List<Item> savedItems = new ArrayList<>();
		for(Item i :  items) {
			itemRepository.save(i);
		}
		return savedItems;
	}

}
