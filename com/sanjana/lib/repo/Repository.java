package com.sanjana.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjana.lib.entity.Product;

public interface Repository extends JpaRepository<Product, Integer>{
	

}
