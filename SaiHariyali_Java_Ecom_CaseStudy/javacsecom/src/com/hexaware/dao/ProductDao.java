package com.hexaware.dao;

import com.hexaware.entity.Products;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {

Connection connection;
Statement statement;
PreparedStatement preparedStatement;
ResultSet resultset;

public void createProduct(Products products) throws ProductNotFoundException {
try {
	 if (productExists(products.getProductId())) {
         System.out.println("Product with id " + products.getProductId() + " already exists.");
         return;
     }
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("insert into products values (?,?,?,?,?)");
preparedStatement.setInt(1, products.getProductId());
preparedStatement.setString(2, products.getName());
preparedStatement.setInt(3, products.getPrice());
preparedStatement.setString(4, products.getDescription());
preparedStatement.setInt(5, products.getStockQuantity());
int noofrows = preparedStatement.executeUpdate();    
System.out.println(noofrows + " " + "Product created successfully");
} catch (SQLException e) {
e.printStackTrace();
}
}

public void deleteProduct(Products products) throws ProductNotFoundException {
try {
	 if (!productExists(products.getProductId())) {
         System.out.println("Product with id " + products.getProductId() + " does not exists.");
         return;
     }
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("delete from products where product_id =?");
preparedStatement.setInt(1, products.getProductId()); 
int noofrows = preparedStatement.executeUpdate();    
System.out.println(noofrows + " " + "Product deleted successfully");
} catch (SQLException e) {
e.printStackTrace();
}
}

public boolean productExists(int productId) throws ProductNotFoundException {
try {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from products where product_id=?");
preparedStatement.setInt(1, productId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch(SQLException e) {
e.printStackTrace();
}
return false;
}
}

