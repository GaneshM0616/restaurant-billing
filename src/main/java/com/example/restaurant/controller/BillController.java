package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.dto.BillRequest;
import com.example.restaurant.model.Bill;
import com.example.restaurant.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping("/create-bill")
	public Bill createBill(@RequestBody BillRequest billRequest) {
		return billService.createBill(billRequest.getItems(), billRequest.getDiscount(),  billRequest.getTax());
	}

	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable Long id) {
		return billService.getBillById(id);
	}
//	
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	
}
