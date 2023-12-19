package com.hexaware.dao;

import com.hexaware.entity.Products;
import com.hexaware.exception.ProductNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController {
ProductDao productdao;
Scanner scanner = new Scanner(System.in);

public void createProduct() throws ProductNotFoundException {
try {
System.out.print("Enter product id: ");
int productid = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter product name: ");
String name = scanner.nextLine();
System.out.print("Enter product price: ");
int price = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter product description: ");
String description = scanner.nextLine(); 
System.out.print("Enter product stock quantity: ");
int stockQuantity = scanner.nextInt(); 
Products products = new Products(productid, name, price, description, stockQuantity);
productdao = new ProductDao();
productdao.createProduct(products);
} catch (InputMismatchException e) {
	// TODO Auto-generated catch block
System.out.println("please enter an integer");
}
}

public void deleteProduct(int productId) throws ProductNotFoundException {
System.out.print("Enter product id to be deleted: ");
int productid = scanner.nextInt();
Products products = new Products(productid);
productdao = new ProductDao();
try {
	productdao.deleteProduct(products);
} catch (ProductNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
