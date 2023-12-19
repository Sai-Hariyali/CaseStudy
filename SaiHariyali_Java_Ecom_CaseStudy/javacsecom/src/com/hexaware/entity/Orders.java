package com.hexaware.entity;

import java.sql.Date;

public class Orders {
private int orderId;
private int customerId;
private Date orderDate;
private int totalPrice;
private String shippingAddress;

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

public Orders() {
super();
// TODO Auto-generated constructor stub
}

public Orders(int orderId, int customerId, Date orderDate, int totalPrice, String shippingAddress) {
super();
this.orderId = orderId;
this.customerId = customerId;
this.orderDate = orderDate;
this.totalPrice = totalPrice;
this.shippingAddress = shippingAddress;
}

public Orders(int customerId) {
// TODO Auto-generated constructor stub
this.customerId = customerId;
}

@Override
public String toString() {
return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
+ ", totalPrice=" + totalPrice + ", shippingAddress=" + shippingAddress + "]";
}

}
