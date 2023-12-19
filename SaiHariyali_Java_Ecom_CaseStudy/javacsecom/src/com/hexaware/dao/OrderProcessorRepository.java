package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.entity.Products;
import java.util.List;
import java.util.Map;

public interface OrderProcessorRepository {

public boolean createProduct(Products products);

public boolean createCustomer(Customers customers);

public boolean deleteProduct(int productId);

public boolean deleteCustomer(int customerId);

public boolean addToCart(Customers customers, Products products, int quantity);

public boolean removeFromCart(Customers customers, Products products);

public List<Products> getAllFromCart(Customers customers);

public boolean placeOrder(Customers customers, 
List<Map<Products, Integer>> productsAndQuantity, String shippingAddress);

public List<Map<Products, Integer>> getOrdersByCustomer(int customerId);
}
