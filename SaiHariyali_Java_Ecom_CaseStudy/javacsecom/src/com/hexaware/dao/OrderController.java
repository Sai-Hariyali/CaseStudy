package com.hexaware.dao;

import com.hexaware.entity.Orders;
import com.hexaware.exception.CustomerNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderController {
OrdersDao ordersdao;
CustomerDao customerdao;
Scanner scanner = new Scanner(System.in);

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
//	e.printStackTrace();
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
