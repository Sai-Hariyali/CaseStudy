package com.hexaware.tests;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.dao.OrdersDao;
import com.hexaware.entity.Orders;
import com.hexaware.exception.CustomerNotFoundException;
/**
 * This is a JUnit test class for testing the functionality of the OrdersDao and OrderProcessorRepositoryImpl classes.
 * It includes a test case for placing an order in the E-commerce system.
 */
public class OrderDaoTest {
OrdersDao ordersdao;
Orders orders;
OrderProcessorRepositoryImpl orderProcessorRepoImpl = new OrderProcessorRepositoryImpl();
/**
 * Set up the test environment before executing each test case.
 */
@Before
public void setUp() {
ordersdao = new OrdersDao();
}
/**
 * Test case for placing an order in the E-commerce system.
 *//**
 * Set up the test environment before executing each test case.
 */
@Test
public void testPlaceOrder(){
int orderId = 13;
int customerId = 4;
String dateString = "2023-12-19";
int totalPrice = 400;
String shippingAddress = "Test Address";
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = null;
try {
utilDate = dateFormat.parse(dateString);
} catch (ParseException e) {
e.printStackTrace();
}
Date orderDate = new Date(utilDate.getTime());
orders.setOrderId(orderId);
orders.setCustomerId(customerId);
orders.setOrderDate(orderDate);
orders.setShippingAddress(shippingAddress);
orders = new Orders(orderId, customerId, orderDate, totalPrice, shippingAddress);
try {
	orderProcessorRepoImpl.placeOrder(orders);
} catch (CustomerNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/**
 * Clean up the test environment after executing each test case.
 */
@After
public void tearDown() {
ordersdao = null;
}

}
