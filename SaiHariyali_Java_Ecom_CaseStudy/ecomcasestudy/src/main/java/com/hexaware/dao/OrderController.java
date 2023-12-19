package com.hexaware.dao;

import com.hexaware.entity.Orders;
import com.hexaware.exception.CustomerNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The OrderController class handles user input and interactions related to orders.
 * It provides methods for placing orders and viewing orders for a specific customer.
 *
 * @author Sai Hariyali
 * @version 1.0
 */
public class OrderController {
	/**
     * The OrdersDao instance for interacting with order-related data.
     */
OrdersDao ordersdao;
/**
 * The CustomerDao instance for interacting with customer-related data.
 */
CustomerDao customerdao;
/**
 * Scanner instance for reading user input from the console.
 */
Scanner scanner = new Scanner(System.in);
/**
 * Places an order by taking input from the user.
 *
 * @throws CustomerNotFoundException if the specified customer is not found.
 * @throws ParseException           if there is an error parsing the date input.
 */
public void orderPlacement() throws CustomerNotFoundException, ParseException {
try {
System.out.print("Enter order id: ");
int orderid = scanner.nextInt();
System.out.print("Enter customer id: ");
int customerid = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter order date: ");
String userInput = scanner.nextLine();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.sql.Date orderDate = null;
try {
java.util.Date utilDate = dateFormat.parse(userInput);
orderDate = new java.sql.Date(utilDate.getTime()); 
} catch (ParseException e) {
System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
return;
}
System.out.print("Enter total price: ");
int totalprice = scanner.nextInt();
scanner.nextLine(); 
System.out.print("Enter shipping address: ");
String shippingaddress = scanner.nextLine(); 
Orders orders = new Orders(orderid, customerid, orderDate, totalprice, shippingaddress);
ordersdao = new OrdersDao();
ordersdao.placeOrder(orders);
} catch (InputMismatchException e) {
// TODO Auto-generated catch block
System.out.println("Invalid input.");
}
}
 /**
     * Views orders for a specific customer by taking input from the user.
     *
     * @throws CustomerNotFoundException if the specified customer is not found.
     */
public void viewCustomerOrder() throws CustomerNotFoundException {
try {
System.out.print("Enter customer id: ");
int customerid = scanner.nextInt();
scanner.nextLine();
customerdao = new CustomerDao();
Orders orders = new Orders(customerid);
ordersdao = new OrdersDao();
ordersdao.viewOrderByCustomerId(orders);
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter a valid integer for customer id.");
}
}
}
