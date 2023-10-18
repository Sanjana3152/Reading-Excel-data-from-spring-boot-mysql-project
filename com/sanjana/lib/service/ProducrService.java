package com.sanjana.lib.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sanjana.lib.entity.Product;
import com.sanjana.lib.helper.Helperclass;
import com.sanjana.lib.repo.Repository;

@Service
public class ProducrService {
	@Autowired
	private Repository repo;
	
	
	public void save(MultipartFile file)
	{
		try{
		
			List<Product> products=	Helperclass.convertExceListOfProduct(file.getInputStream());
			this.repo.saveAll(products);
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}
	public List<Product> getAllProducts(){
		
		
		return this.repo.findAll();
		
		
	}
}
