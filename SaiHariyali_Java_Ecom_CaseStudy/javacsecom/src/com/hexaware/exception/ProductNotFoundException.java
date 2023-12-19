package com.hexaware.exception;

/**
 * ProductNotFoundException is a custom exception class that indicates
 * an error when a product is not found in the system.
 * 
 *<p>Usage:
 * - This exception is thrown when attempting to retrieve or perform operations
 *  on a non-existing product.
 *  
 *<p>Features:
 * - Provides a customized error message when a product is not found.
 * - Overrides the toString() method to return a more descriptive error message.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-01
 */

public class ProductNotFoundException extends Exception {

private static final long serialVersionUID = 1L;

public ProductNotFoundException() {
System.out.println("products not found");
}

public String toString() {
return "incorrect credentials";
}
}
