package com.hexaware.main;

import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.entity.Cart;
import com.hexaware.entity.Customers;
import com.hexaware.entity.Orders;
import com.hexaware.entity.Products;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * EcomApp is the main class for the Ecommerce Application.
 * It provides a command-line interface for users to interact with the system.
 * Users can register customers, create products, manage the cart, place orders, 
 * and view customer orders.
 * 
 *<p>Usage:
 * - Run the application and choose options from the menu.
 * - The application continues to execute until the user chooses to exit.
 * 
 *<p>Features:
 * 1. Register Customer - Allows users to register a new customer.
 * 2. Create Product - Allows users to create a new product.
 * 3. Delete Product - Allows users to delete a product. 
 * 4. Add to Cart - Allows users to add products to their shopping cart.
 * 5. View Cart - Allows users to view the contents of their shopping cart.
 * 6. Place Order - Allows users to place an order based on the items in their cart.
 * 7. View Customer Order - Allows users to view their past orders.
 * 
 *<p>Dependencies:
 * - OrderProcessorRepositoryImpl - Handles the business logic for order processing.
 * - Customers, Products, Cart, Orders - Entity classes representing customers,
 * products, cart, and orders.
 * - CustomerNotFoundException - Custom exception for customer not found.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-16
 */
public class EcomApp {
public static void main(String[] args) {

OrderProcessorRepositoryImpl orderprocessorrepositoryimpl = new OrderProcessorRepositoryImpl();
Customers customer;
Products product;
Cart cart;
Orders orders;
Scanner scanner = new Scanner(System.in);
String ch = null;
do {
System.out.println("Ecommerce Application Menu:");
System.out.println("1. Register Customer.");
System.out.println("2. Create Product");
System.out.println("3. Delete Product");
System.out.println("4. Add to cart");
System.out.println("5. View Cart");
System.out.println("6. Place Order");
System.out.println("7. View Customer Order");
System.out.println("Enter your choice");
int choice = scanner.nextInt();
switch (choice) {
case 1: {
customer = new Customers();
orderprocessorrepositoryimpl.createCustomer(customer);
break;
}
case 2: {
product = new Products();
orderprocessorrepositoryimpl.createProduct(product);
break;
}
case 3: {
product = new Products();
int productId = 0;
orderprocessorrepositoryimpl.deleteProduct(productId);
break;
}
case 4: {
cart = new Cart();
orderprocessorrepositoryimpl.addToCart(cart);
break;
}
case 5: {
cart = new Cart();
orderprocessorrepositoryimpl.getAllfromCart(cart);
break;
}
case 6: {
orders = new Orders();
try {
	orderprocessorrepositoryimpl.placeOrder(orders);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
break;
}
case 7: {
orders = new Orders();
try {
orderprocessorrepositoryimpl.getOrderByCustomer(orders);
} catch (CustomerNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
break;
}
default: {
System.out.println("Choose a proper choice");
break;
}
}
System.out.println("Do you want to continue? Y | y");
ch = scanner.next();
} while (ch.equals("Y") || ch.equals("y"));
System.out.println("Thanks for using our system");
scanner.close();
}
}
