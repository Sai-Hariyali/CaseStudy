package com.hexaware.entity;

/**
 * OrderItems is a class representing items within an order in the Ecommerce Application.
 * Each OrderItem consists of an order item ID, order ID, product ID, and quantity.
 * 
 *<p>Usage:
 * - OrderItems are used to track individual items within a customer's order.
 * 
 *<p>Properties:
 * - orderItemId: Unique identifier for the order item.
 * - orderId: Identifier for the order to which the item belongs.
 * - productId: Identifier for the product associated with the order item.
 * - quantity: The quantity of the product in the order item.
 * 
 *<p>Constructors:
 * - OrderItems(): Default constructor with no parameters.
 * - OrderItems(orderItemId, orderId, productId, quantity): 
 * Parameterized constructor to set properties.
 * 
 *<p>Methods:
 * - Getters and setters for all properties.
 * - toString(): Provides a string representation of the OrderItems object.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-16
 */

public class OrderItems {
private int orderItemId;
private int orderId;
private int productId;
private int quantity;

public int getOrderItemId() {
return orderItemId;
}

public void setOrderItemId(int orderItemId) {
this.orderItemId = orderItemId;
}

public int getOrderId() {
return orderId;
}

public void setOrderId(int orderId) {
this.orderId = orderId;
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

public OrderItems() {
super();
// TODO Auto-generated constructor stub
}

public OrderItems(int orderItemId, int orderId, int productId, int quantity) {
super();
this.orderItemId = orderItemId;
this.orderId = orderId;
this.productId = productId;
this.quantity = quantity;
}

@Override
public String toString() {
return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ","
+ " productId=" + productId
+ ", quantity=" + quantity + "]";
}

}
