package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.exception.CustomerNotFoundException;

import java.util.Scanner;

public class CustomerController {

CustomerDao customerdao;
Scanner scanner = new Scanner(System.in);

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
