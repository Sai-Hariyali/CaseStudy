package com.hexaware.exception;

/**
 * OrderNotFoundException is a custom exception class representing the scenario
 * where an order is not found in the system.
 * 
 *<p>This exception is typically thrown when attempting to retrieve or manipulate
 * an order that does not exist.
 * 
 *<p>Usage:
 * - Handle instances of OrderNotFoundException when interacting with order-related operations.
 * - Provides a user-friendly message indicating that the order was not found.
 * - Overrides the toString method to return a customized error message.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-16
 */
public class OrderNotFoundException extends Exception {

private static final long serialVersionUid = 1L;

public OrderNotFoundException() {
System.out.println("order not found");
}

public String toString() {
return "Order not found";
}
}
