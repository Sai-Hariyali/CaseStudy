package com.hexaware.dao;

import com.hexaware.entity.Cart;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The CartController class is responsible for handling cart-related operations.
 * It interacts with the user via the console and communicates with the CartDao
 * for database operations.
 */
public class CartController {
/**
* The CartDao instance to interact with the database.
*/

CartDao cartdao;
/**
 * Scanner object for user input.
 */
Scanner scanner = new Scanner(System.in);
/**
 * Adds a new entry to the cart.
 * 
 * @throws ProductNotFoundException If the specified product is not found.
 * @throws CustomerNotFoundException If the specified customer is not found.
 */
public void addCart() throws ProductNotFoundException, CustomerNotFoundException {
try {
System.out.print("Enter cart id: ");
int cartid = scanner.nextInt();
System.out.print("Enter customer id: ");
int customerid = scanner.nextInt();
System.out.print("Enter product id: ");
int productid = scanner.nextInt();
System.out.print("Enter product quantity: ");
int quantity = scanner.nextInt();
Cart cart = new Cart(cartid, customerid, productid, quantity);
cartdao = new CartDao();
cartdao.newCartEntry(cart);
} catch (InputMismatchException e) {
// TODO Auto-generated catch block
System.out.println("please enter an integer");
}
}
/**
 * Views the cart for a specific customer.
 * 
 * @throws CustomerNotFoundException If the specified customer is not found.
 */
public void viewCustomerCart() throws CustomerNotFoundException {
try {
System.out.print("Enter customer id: ");
int customerid = scanner.nextInt();
Cart cart = new Cart(customerid);
cartdao = new CartDao();
cartdao.viewCartByCustomerId(cart);
//cartdao.viewFullCart();
} catch (InputMismatchException e) {
// TODO Auto-generated catch block
System.out.println("please enter an integer");
}
}
}
