package com.itts.dao;
import java.util.List;

import com.itts.model.Product;

public interface ProductDAO {
	
 public abstract boolean addProduct(Product product);
 public abstract List<Product> getAllProducts();
}
