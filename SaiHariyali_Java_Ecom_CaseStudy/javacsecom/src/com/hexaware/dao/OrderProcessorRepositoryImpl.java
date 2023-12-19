package com.hexaware.dao;

import com.hexaware.entity.Cart;
import com.hexaware.entity.Customers;
import com.hexaware.entity.Orders;
import com.hexaware.entity.Products;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class OrderProcessorRepositoryImpl implements OrderProcessorRepository {
CustomerController customercontroller;
ProductController productcontroller;
CartController cartcontroller;
OrderController ordercontroller;

@Override
public boolean createProduct(Products products) {
// TODO Auto-generated method stub
productcontroller = new ProductController();
try {
	productcontroller.createProduct();
} catch (ProductNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;
}

@Override
public boolean createCustomer(Customers customers) {
// TODO Auto-generated method stub
customercontroller = new CustomerController();
try {
	customercontroller.createCustomer();
} catch (CustomerNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;
}

@Override
public boolean deleteProduct(int productId) {
// TODO Auto-generated method stub
productcontroller = new ProductController();
try {
	productcontroller.deleteProduct(productId);
} catch (ProductNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return false;
}

@Override
public boolean deleteCustomer(int customerId) {
// TODO Auto-generated method stub
return false;
}



@Override
public List<Products> getAllFromCart(Customers customers) {
// TODO Auto-generated method stub
return null;
}

@Override
public List<Map<Products, Integer>> getOrdersByCustomer(int customerId) {
// TODO Auto-generated method stub
return null;
}

public void addToCart(Cart cart) {
// TODO Auto-generated method stub
try {
	cartcontroller = new CartController();
	cartcontroller.addCart();
} catch (ProductNotFoundException e) {
	// TODO Auto-generated catch block
	e.getMessage();
} catch (CustomerNotFoundException e) {
	// TODO Auto-generated catch block
	e.getMessage();
}
}

@Override
public boolean addToCart(Customers customers, Products products, int quantity) {
// TODO Auto-generated method stu
return false;
}

public void getAllfromCart(Cart cart) {
// TODO Auto-generated method stub
cartcontroller = new CartController();
try {
	cartcontroller.viewCustomerCart();
} catch (CustomerNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public void placeOrder(Orders orders) throws ParseException {
// TODO Auto-generated method stub
ordercontroller = new OrderController();
try {
	ordercontroller.orderPlacement();
} catch (CustomerNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.getMessage();
}
}

@Override
public boolean placeOrder(Customers customers, List<Map<Products, Integer>> productsAndQuantity,
String shippingAddress) {
// TODO Auto-generated method stub
return false;
}

public void getOrderByCustomer(Orders orders) throws CustomerNotFoundException {
// TODO Auto-generated method stub
ordercontroller = new OrderController();
ordercontroller.viewCustomerOrder();
}

@Override
public boolean removeFromCart(Customers customers, Products products) {
	// TODO Auto-generated method stub
	return false;
}
}
