package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.entity.Products;
import java.util.List;
import java.util.Map;
/**
 * The OrderProcessorRepository interface defines methods for interacting with the order processing system.
 * It includes operations related to product and customer management, cart manipulation,
 * order placement, and retrieval of order information.
 */
public interface OrderProcessorRepository {
	/**
     * Creates a new product in the system.
     *
     * @param products The product to be created.
     * @return true if the product is created successfully; false otherwise.
     */
public boolean createProduct(Products products);
/**
 * Creates a new customer in the system.
 *
 * @param customers The customer to be created.
 * @return true if the customer is created successfully; false otherwise.
 */
public boolean createCustomer(Customers customers);
/**
 * Deletes a product from the system.
 *
 * @param productId The ID of the product to be deleted.
 * @return true if the product is deleted successfully; false otherwise.
 */
public boolean deleteProduct(int productId);
/**
 * Deletes a customer from the system.
 *
 * @param customerId The ID of the customer to be deleted.
 * @return true if the customer is deleted successfully; false otherwise.
 */
public boolean deleteCustomer(int customerId);
/**
 * Adds a product to the customer's shopping cart with the specified quantity.
 *
 * @param customers The customer whose cart is updated.
 * @param products The product to be added to the cart.
 * @param quantity The quantity of the product to be added.
 * @return true if the product is added to the cart successfully; false otherwise.
 */
public boolean addToCart(Customers customers, Products products, int quantity);
/**
 * Removes a product from the customer's shopping cart.
 *
 * @param customers The customer whose cart is updated.
 * @param products The product to be removed from the cart.
 * @return true if the product is removed from the cart successfully; false otherwise.
 */
public boolean removeFromCart(Customers customers, Products products);
/**
 * Retrieves all products from the customer's shopping cart.
 *
 * @param customers The customer whose cart is queried.
 * @return A list of products in the customer's cart.
 */
public List<Products> getAllFromCart(Customers customers);
/**
 * Places an order for the specified customer with the given products and quantities,
 * and provides a shipping address for delivery.
 *
 * @param customers The customer placing the order.
 * @param productsAndQuantity A list of products and their corresponding quantities in the order.
 * @param shippingAddress The shipping address for delivering the order.
 * @return true if the order is placed successfully; false otherwise.
 */
public boolean placeOrder(Customers customers, 
List<Map<Products, Integer>> productsAndQuantity, String shippingAddress);
/**
 * Retrieves a list of orders with products and quantities placed by the specified customer.
 *
 * @param customerId The ID of the customer whose orders are queried.
 * @return A list of orders with products and quantities.
 */
public List<Map<Products, Integer>> getOrdersByCustomer(int customerId);
}
