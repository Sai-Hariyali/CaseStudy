package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.exception.CustomerNotFoundException;
import java.util.Scanner;
/**
 * The {@code CustomerController} class is responsible for handling customer-related operations
 * in the E-commerce system. It interacts with the user to create and manage customer information.
 * 
 * <p>The class utilizes the {@link CustomerDao} for database operations related to customers.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2023-01-01
 */
public class CustomerController {

CustomerDao customerdao;
/**
 * The scanner object to read input from the user.
 */
Scanner scanner = new Scanner(System.in);
/**
 * Creates a new customer by gathering information from the user and
 * registers the customer using the {@code CustomerDao}.
 * 
 * @throws CustomerNotFoundException if an issue occurs while registering the customer.
 */
public void createCustomer() throws CustomerNotFoundException {
System.out.print("Enter customer id: ");
int customerid = scanner.nextInt();
System.out.print("Enter customer name: ");
String name = scanner.next();
System.out.print("Enter customer email: ");
String email = scanner.next();
System.out.print("Enter customer password: ");
String password = scanner.next();
Customers customers = new Customers(customerid, name, email, password);
customerdao = new CustomerDao();
customerdao.registerCustomer(customers);
}
}
