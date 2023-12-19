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
/**
 * Implementation of the {@link OrderProcessorRepository} interface.
 * Handles the processing of orders, customers, products, and carts.
 */
public class OrderProcessorRepositoryImpl implements OrderProcessorRepository {
CustomerController customercontroller;
ProductController productcontroller;
CartController cartcontroller;
OrderController ordercontroller;
/**
 * Creates a new product.
 *
 * @param products The product to be created.
 * @return true if the product is created successfully, false otherwise.
 */
public boolean createProduct(Products products) {
// TODO Auto-generated method stub
productcontroller = new ProductController();
try {
productcontroller.createProduct();
} catch (ProductNotFoundException e) {
e.printStackTrace();
}
return false;
}
/**
 * Creates a new customer.
 *
 * @param customers The customer to be created.
 * @return true if the customer is created successfully, false otherwise.
 */
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
/**
 * Deletes a product.
 *
 * @param productId The ID of the product to be deleted.
 * @return true if the product is deleted successfully, false otherwise.
 */
public boolean deleteProduct(int productId) {
// TODO Auto-generated method stub
productcontroller = new ProductController();
try {
productcontroller.deleteProduct(productId);
} catch (ProductNotFoundException e) {
e.printStackTrace();
}
return false;
}
/**
 * Deletes a customer.
 *
 * @param customerId The ID of the customer to be deleted.
 * @return true if the customer is deleted successfully, false otherwise.
 */
public boolean deleteCustomer(int customerId) {
// TODO Auto-generated method stub
return false;
}
/**
 * Removes a product from the customer's cart.
 *
 * @param customers The customer from whose cart the product is to be removed.
 * @param products  The product to be removed from the cart.
 * @return true if the product is removed successfully, false otherwise.
 */
public boolean removeFromCart(Customers customers, Products products) {
// TODO Auto-generated method stub
return false;
}
/**
 * Gets the orders placed by a customer.
 *
 * @param customerId The ID of the customer.
 * @return A list of maps containing products and their quantities in each order.
 */

public List<Map<Products, Integer>> getOrdersByCustomer(int customerId) {
// TODO Auto-generated method stub
return null;
}
/**
 * Adds a cart to the system.
 *
 * @param cart The cart to be added.
 */
public void addToCart(Cart cart) {
// TODO Auto-generated method stub
try {
    cartcontroller = new CartController();
cartcontroller.addCart();
} catch (ProductNotFoundException e) {
e.getMessage();
} catch (CustomerNotFoundException e) {
e.getMessage();
}
}
/**
 * Adds a product to the customer's cart.
 *
 * @param customers The customer to whose cart the product is to be added.
 * @param products  The product to be added to the cart.
 * @param quantity  The quantity of the product to be added.
 * @return true if the product is added to the cart successfully, false otherwise.
 */
public boolean addToCart(Customers customers, Products products, int quantity) {
// TODO Auto-generated method stu
return false;
}
/**
 * Displays all products in the customer's cart.
 *
 * @param cart The cart to be displayed.
 */
public void getAllfromCart(Cart cart) {
// TODO Auto-generated method stub
cartcontroller = new CartController();
try {
cartcontroller.viewCustomerCart();
} catch (CustomerNotFoundException e) {
e.printStackTrace();
}
}

public void placeOrder(Orders orders) throws CustomerNotFoundException, ParseException {
// TODO Auto-generated method stub
ordercontroller = new OrderController();
try {
ordercontroller.orderPlacement();
} catch (CustomerNotFoundException e) {
e.getMessage();
} catch (ParseException e) {
e.getMessage();
}
}
/**
 * Places an order in the system.
 *
 * @param orders The order to be placed.
 * @throws CustomerNotFoundException If the customer is not found.
 * @throws ParseException            If there is an issue with parsing.
 */
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
public List<Products> getAllFromCart(Customers customers) {
// TODO Auto-generated method stub
return null;
}

}
