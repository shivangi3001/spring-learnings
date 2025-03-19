package com.springrest.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.app.entity.Address;
import com.springrest.app.entity.ProductEntity;
import com.springrest.app.entity.SellerEntity;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/get-product")
	public ProductEntity getProduct() {
		return new ProductEntity("USB Mouse", 900.0f, 
								 new SellerEntity("XYZ Pvt Ltd", (byte) 4, 
										    new Address("Boring Road", "Patna", "800006"))
					);
	}
	
	@GetMapping("/get-all-products")
	public List<ProductEntity> getAllProducts() {
		return Arrays.asList(new ProductEntity("USB Mouse", 900.0f, 
								 new SellerEntity("XYZ Pvt Ltd", (byte) 4, 
										    new Address("Boring Road", "Patna", "800006"))
					), 
				new ProductEntity("i5 Asus Laptop", 90000.0f, 
						 new SellerEntity("Mahi Computers", (byte) 4, 
								    new Address("SP Verma Road", "Patna", "800006"))
			),
				new ProductEntity("CCTV Camera Vision", 900.0f, 
						 new SellerEntity("EageEye CCTV Solutions", (byte) 4, 
								    new Address("Nehru Place", "Delhi", "400002"))
			)
				);
	}

}
