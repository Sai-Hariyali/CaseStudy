package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {
Connection connection;
  Statement statement;
PreparedStatement preparedStatement;
ResultSet resultset;

public void registerCustomer(Customers customers)throws CustomerNotFoundException {
try {
	 if (customerExists(customers.getCustomerId())) {
         System.out.println("Customer with id " + customers.getCustomerId() + " already exists.");
         return;
      }
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("insert into customers values (?,?,?,?)");
preparedStatement.setInt(1, customers.getCustomerId());
preparedStatement.setString(2, customers.getName());
preparedStatement.setString(3, customers.getEmail());
preparedStatement.setString(4, customers.getPassword());
int noofrows = preparedStatement.executeUpdate();    
System.out.println(noofrows + " " + "Customer registered successfully");
} catch (SQLException e) {
            e.printStackTrace();
        }
}

public boolean customerExists(int customerId) throws CustomerNotFoundException {
try {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from customers where customer_id=?");
preparedStatement.setInt(1, customerId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}
}
