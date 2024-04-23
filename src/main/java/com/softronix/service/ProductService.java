package com.softronix.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softronix.entity.Product;
import com.softronix.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired(required=true)
	ProductRepository repository;
	
	public Product addPro(Product product)
	{
		return repository.save(product);
	}
	
	public List<Product> getPros()
	{
		return repository.findAll();
	}
	
	public Product getProId(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public String delPro(int id)
	{
		repository.deleteById(id);
		return "Succesfully Deleted";
	}
	
	public Product upPro(Product product)
	{
		Product exist = repository.findById(product.getId()).orElse(null);
		exist.setName(product.getName());
		exist.setQuantity(product.getQuantity());
		exist.setPrice(product.getPrice());
		
		return repository.save(exist);
	}

}
