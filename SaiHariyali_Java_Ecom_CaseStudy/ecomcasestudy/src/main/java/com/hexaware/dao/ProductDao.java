package com.hexaware.dao;

import com.hexaware.entity.Products;
import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The ProductDao class provides methods to interact with the database for Product-related operations.
 */
public class ProductDao {

Connection connection;
Statement statement;
PreparedStatement preparedStatement;
ResultSet resultset;
/**
 * Creates a new product in the database.
 *
 * @param products The Products object representing the product to be created.
 * @return true if the product is created successfully, false otherwise.
 * @throws ProductNotFoundException If there is an issue with the product creation process.
 */
public boolean createProduct(Products products) throws ProductNotFoundException {
try {
if (productExists(products.getProductId())) {
         System.out.println("Product with id " + products.getProductId() + " already exists.");
         return true;
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
return true;
}
/**
 * Deletes a product from the database.
 *
 * @param products The Products object representing the product to be deleted.
 * @throws ProductNotFoundException If the product does not exist in the database.
 */
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
/**
 * Checks if a product with the given ID exists in the database.
 *
 * @param productId The ID of the product to check.
 * @return true if the product exists, false otherwise.
 * @throws ProductNotFoundException If there is an issue with the product existence check.
 */
public boolean productExists(int productId) throws ProductNotFoundException {
try {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from products where product_id=?");
preparedStatement.setInt(1, productId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}

}

