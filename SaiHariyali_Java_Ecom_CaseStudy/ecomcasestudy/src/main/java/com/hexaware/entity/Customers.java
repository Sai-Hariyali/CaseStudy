package com.hexaware.entity;

/**
 * Customers class represents a customer entity in the Ecommerce Application.
 * It contains information such as customer ID, name, email, and password.
 * 
 *<p>Usage:
 * - Customers object is used to store and retrieve customer information.
 * 
 *<p>Constructors:
 * - Default constructor: Initializes an empty Customers object.
 * - Parameterized constructor: Initializes a Customers object with specified values.
 * 
 *<p>Getters and Setters:
 * - getCustomerId(): Retrieves the customer ID.
 * - setCustomerId(int customerId): Sets the customer ID.
 * - getName(): Retrieves the customer's name.
 * - setName(String name): Sets the customer's name.
 * - getEmail(): Retrieves the customer's email.
 * - setEmail(String email): Sets the customer's email.
 * - getPassword(): Retrieves the customer's password.
 * - setPassword(String password): Sets the customer's password.
 * 
 *<p>toString():
 * - Provides a string representation of the Customers object, useful for debugging and logging.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-01
 */

public class Customers {
private int customerId; 
private String name;
private String email;
private String password;

public int getCustomerId() {
return customerId;
}

public void setCustomerId(int customerId) {
this.customerId = customerId;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public Customers() {
super();
// TODO Auto-generated constructor stub
}

public Customers(int customerId, String name, String email, String password) {
super();
this.customerId = customerId;
this.name = name;
this.email = email;
this.password = password;
}

@Override
public String toString() {
return "Customers [customerId=" + customerId + ", name=" + name + ","
+ " email=" + email + ", password=" + password
+ "]";
}
}
