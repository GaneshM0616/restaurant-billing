package com.example.restaurant.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.dto.BillItemRequest;
import com.example.restaurant.model.Bill;
import com.example.restaurant.model.BillItem;
import com.example.restaurant.model.Item;
import com.example.restaurant.repository.BillRepository;
import com.example.restaurant.repository.ItemRepository;

@Service
public class BillService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private BillRepository billRepository;

	public Bill createBill(List<BillItemRequest> itemsRequest, Double discount, Double tax) {
		Bill bill = new Bill();
		bill.setDiscount(discount);
		bill.setTax(tax);
		bill.setDate(LocalDateTime.now());
		
		double totalAmount = 0.0;
		
		List<BillItem> billItems = new ArrayList<>();
		
		for(BillItemRequest itemRequest : itemsRequest) {
			Optional<Item> itemOpt = itemRepository.findById(itemRequest.getItemId());
			if(itemOpt.isPresent()) {
				Item item = itemOpt.get();
				
				double itemTotal = item.getPrice() * itemRequest.getQuantity();
				
				BillItem billItem = new BillItem();
				
				billItem.setName(item.getName());
				billItem.setPrice(item.getPrice());
				billItem.setQuantity(item.getQuantity());
				billItem.setBill(bill);
				
				billItems.add(billItem);
				totalAmount += itemTotal;
			}

		}
		
		 totalAmount = totalAmount - (totalAmount * (discount / 100));
	     totalAmount = totalAmount + (totalAmount * (tax / 100));
	        
	     totalAmount = Math.round(totalAmount * 100.0) / 100.0;
	     
	     bill.setTotalAmount(totalAmount);
	     bill.setItems(billItems);
	     
	     return billRepository.save(bill);
	     
	}

	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	public Bill getBillById(Long id) {
		return billRepository.findById(id).orElse(null);
	}

}
