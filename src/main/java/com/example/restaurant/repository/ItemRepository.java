package com.example.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
