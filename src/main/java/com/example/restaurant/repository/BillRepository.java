package com.example.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
