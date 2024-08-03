package com.example.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.model.Item;
import com.example.restaurant.service.ItemService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:5173") // Allow your frontend origin 
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/additem")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@GetMapping("/{id}")
	public Optional<Item> getItemById(@PathVariable Long id){
		return itemService.getItemById(id);
	}
	
	@GetMapping
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@PutMapping("/update/{id}")
	public Item updateItembyId(@PathVariable Long id ,@RequestBody Item item){
		return itemService.updateItem(item, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteItemById(@PathVariable Long id) {
		itemService.deleteItem(id);
	}
	
	@PostMapping("/add-multiple")
	public List<Item> addMultipleItems(@RequestBody List<Item> items){
		return itemService.addMultipleItems(items);
		
	}

}
