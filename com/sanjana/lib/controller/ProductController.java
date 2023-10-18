package com.sanjana.lib.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.multipart.MultipartFile;

import com.sanjana.lib.entity.Product;
import com.sanjana.lib.helper.Helperclass;
//import com.sanjana.lib.helper.Helperclass;
import com.sanjana.lib.service.ProducrService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProducrService p;
	
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)	{
		if(Helperclass.CheckExcelFormat(file))
		{
			p.save(file);
			return ResponseEntity.ok(Map.of("message", "File is uploadedand data is saved in db"));
	}
		
		
		
	
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload valid format file");
	

}
	@GetMapping("/product")
public List<Product> getAllProducts(){
	return this.p.getAllProducts();
	
}




}

