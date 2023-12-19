package com.hexaware.dao;

import com.hexaware.entity.Orders;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class OrdersDao {
Connection connection;
Statement statement;
PreparedStatement preparedStatement;
ResultSet resultset;

public void placeOrder(Orders orders)throws CustomerNotFoundException,ParseException {
try {
	if (!customerExists(orders.getCustomerId())) {
        System.out.println("Customer with id " + orders.getCustomerId() + " does not exists.");
        return;
    }
	if (orderExists(orders.getOrderId())) {
        System.out.println("Order with id " + orders.getOrderId() + " already exists.");
        return;
    }
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("insert into orders values (?,?,?,?,?)");
preparedStatement.setInt(1, orders.getOrderId());
preparedStatement.setInt(2, orders.getCustomerId());
preparedStatement.setDate(3, orders.getOrderDate());
preparedStatement.setInt(4, orders.getTotalPrice());
preparedStatement.setString(5, orders.getShippingAddress());
int noofrows = preparedStatement.executeUpdate();    
System.out.println(noofrows + " " + "order placed successfully");
} catch (SQLException e) {
e.printStackTrace();
} 
}

public void viewOrderByCustomerId(Orders orders) throws CustomerNotFoundException {
try {
	 if (!customerExists(orders.getCustomerId())) {
         System.out.println("Customer with id " + orders.getCustomerId() + " does not exist.");
         return;
     }
connection = DBConnUtil.getMyDBConnection();
statement = connection.createStatement();
preparedStatement = connection.prepareStatement("select * from orders where customer_id = ?");
preparedStatement.setInt(1, orders.getCustomerId());
resultset = preparedStatement.executeQuery();
while (resultset.next()) {
System.out.println("Order id  : " + resultset.getInt(1));
System.out.println("Customer id  : " + resultset.getInt(2));
java.sql.Date orderDateSql = resultset.getDate(3);
java.util.Date orderDateUtil = new java.util.Date(orderDateSql.getTime());
System.out.println("Order date :" + orderDateUtil);
System.out.println("Total Price :" + resultset.getInt(4));
System.out.println("Shipping Address :" + resultset.getString(5));
System.out.println("------------");
}
} catch (SQLException e) {
e.printStackTrace();
System.out.println("SQL Error: " + e.getMessage());
}
}

public boolean orderExists(int orderId) {
try  {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from orders where order_id = ?");
preparedStatement.setInt(1, orderId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}

public boolean customerExists(int customerId) throws CustomerNotFoundException {
try  {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from orders where customer_id = ?");
preparedStatement.setInt(1, customerId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}

public void viewAllOrders() {
try {
connection = DBConnUtil.getMyDBConnection();
statement = connection.createStatement();
resultset = statement.executeQuery("select * from orders");
while (resultset.next()) {
System.out.println("Order id:" + resultset.getInt(1));
System.out.println("Customer id:" + resultset.getInt(2));
java.sql.Date orderDateSql = resultset.getDate(3);
java.util.Date orderDateUtil = new java.util.Date(orderDateSql.getTime());
System.out.println("Order date :" + orderDateUtil);
System.out.println("Total Price :" + resultset.getInt(4));
System.out.println("Shipping Address :" + resultset.getString(5));
System.out.println("------");
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}
