package com.hexaware.dao;

import com.hexaware.entity.Customers;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The CustomerDao class provides methods to interact with the database
 * for managing customer information.
 *
 * @author Sai Hariyali
 * @version 1.0
 */
public class CustomerDao {
	/**
     * Connection to the database.
     */	
Connection connection;

/**
 * Statement to execute SQL queries.
 */
  Statement statement;
/**
     * Prepared statement to execute parameterized SQL queries.
     */  
PreparedStatement preparedStatement;
/**
 * Result set to store the result of SQL queries.
 */
ResultSet resultset;
/**
 * Registers a new customer in the database.
 *
 * @param customers The Customers object representing the customer to be registered.
 * @throws CustomerNotFoundException If the customer with the same ID already exists.
 */
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
/**
 * Checks if a customer with the given ID exists in the database.
 *
 * @param customerId The ID of the customer to check.
 * @return True if the customer exists, false otherwise.
 * @throws CustomerNotFoundException If an exception occurs while checking for the customer.
 */
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
