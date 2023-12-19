package com.hexaware.entity;

import java.sql.Date;
/**
 * The Orders class represents an order in the e-commerce system.
 * It contains information such as order ID, customer ID, order date,
 * total price, and shipping address.
 */
public class Orders {
private int orderId;
private int customerId;
private Date orderDate;
private int totalPrice;
private String shippingAddress;
/**
 * Getters and setters for the private fields.
 */
public int getOrderId() {
return orderId;
}

public void setOrderId(int orderId) {
this.orderId = orderId;
}

public int getCustomerId() {
return customerId;
}

public void setCustomerId(int customerId) {
this.customerId = customerId;
}

public Date getOrderDate() {
return orderDate;
}

public void setOrderDate(Date orderDate) {
this.orderDate = orderDate;
}

public int getTotalPrice() {
return totalPrice;
}

public void setTotalPrice(int totalPrice) {
this.totalPrice = totalPrice;
}

public String getShippingAddress() {
return shippingAddress;
}

public void setShippingAddress(String shippingAddress) {
this.shippingAddress = shippingAddress;
}
/**
 * Default constructor for the Orders class.
 */
public Orders() {
super();
// TODO Auto-generated constructor stub
}
/**
 * Parameterized constructor to initialize an Orders object.
 *
 * @param orderId         The unique identifier for the order.
 * @param customerId      The customer ID associated with the order.
 * @param orderDate       The date when the order was placed.
 * @param totalPrice      The total price of the order.
 * @param shippingAddress The shipping address for delivering the order.
 */
public Orders(int orderId, int customerId, Date orderDate, int totalPrice, String shippingAddress) {
super();
this.orderId = orderId;
this.customerId = customerId;
this.orderDate = orderDate;
this.totalPrice = totalPrice;
this.shippingAddress = shippingAddress;
}
/**
 * Constructor with customer ID parameter for creating an Orders object.
 *
 * @param customerId The customer ID associated with the order.
 */
public Orders(int customerId) {
// TODO Auto-generated constructor stub
this.customerId = customerId;
}
/**
 * Overrides the toString method to provide a string representation of the Orders object.
 *
 * @return A string representation of the Orders object.
 */
@Override
public String toString() {
return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
+ ", totalPrice=" + totalPrice + ", shippingAddress=" + shippingAddress + "]";
}

}
