package com.aneinus.springapp.service;

import java.util.List;

import com.aneinus.springapp.domain.Product;

public class SimpleProductManager implements ProductManager {

	private List<Product> products;
	
	@Override
	public void increasePrice(int percentage) {
		if (products != null)
		{
			for (Product p : products)
			{
				double newPrice = p.getPrice().doubleValue() * (100+percentage)/100;
				p.setPrice(newPrice);
			}
		}
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

}
