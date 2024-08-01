package com.example.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant.model.BillItem;

public interface BillItemRepository extends JpaRepository<BillItem, Long>{

}
