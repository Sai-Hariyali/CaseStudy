package com.hexaware.entity;

/**
 * The Cart class represents a shopping cart in the Ecommerce system.
 * It stores information about the items added to the cart by customers.
 * 
 * <p>Properties:
 * - cartId: Identifier for the shopping cart.
 * - customerId: Identifier for the customer associated with the cart.
 * - productId: Identifier for the product added to the cart.
 * - quantity: Quantity of the product added to the cart.
 * 
 *<p>Constructors:
 * - Cart(): Default constructor.
 * - Cart(int cartId, int customerId, int productId, int quantity): Parameterized constructor.
 * - Cart(int customerId): Constructor for initializing a cart with a specific customer.
 * 
 *<p>Methods:
 * - Getter and setter methods for accessing and modifying cart properties.
 * - toString(): Returns a string representation of the Cart object.
 * 
 *<p>Usage:
 * - Create instances of Cart to manage items in a customer's shopping cart.
 * - Use the various constructors to initialize the cart properties.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-16
 */

public class Cart {
private int cartId;
private int customerId;
private int productId;
private int quantity;

public int getCartId() {
return cartId;
}

public void setCartId(int cartId) {
this.cartId = cartId;
}

public int getCustomerId() {
return customerId;
}

public void setCustomerId(int customerId) {
this.customerId = customerId;
}

public int getProductId() {
return productId;
}

public void setProductId(int productId) {
this.productId = productId;
}

public int getQuantity() {
return quantity;
}

public void setQuantity(int quantity) {
this.quantity = quantity;
}

public Cart() {
super();
// TODO Auto-generated constructor stub
}

public Cart(int cartId, int customerId, int productId, int quantity) {
super();
this.cartId = cartId;
this.customerId = customerId;
this.productId = productId;
this.quantity = quantity;
}

public Cart(int customerId) {
// TODO Auto-generated constructor stub
this.customerId = customerId;
}

@Override
public String toString() {
return "Cart [cartId=" + cartId + ", customerId=" + customerId + ","
+ " productId=" + productId + ", quantity="
+ quantity + "]";
}
}
