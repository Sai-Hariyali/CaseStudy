package com.hexaware.exception;

/**
 * CustomerNotFoundException is a custom exception class that extends the Exception class.
 * It is thrown when a customer is not found in the system based on the provided criteria.
 *  
 *<p>This exception is commonly used to handle cases where a customer ID is not found during
 * customer-related operations in the Ecommerce system.
 * 
 *<p>Features:
 * - toString() - Overrides the toString() method to provide a custom error message.
 * - CustomerNotFoundException() - Default constructor displaying a generic error message.
 * 
 *<p>Usage:
 * - Instances of this exception are thrown in situations where a customer is not found.
 * - Users can catch this exception to handle the specific case of customer not found gracefully.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-16
 */

public class CustomerNotFoundException extends Exception {
private static final long serialVersionUID = 1L;

public String toString() {
return "incorrect credentials";
}

public CustomerNotFoundException() {
System.out.println("customer not found, please enter a valid id");
}
}
