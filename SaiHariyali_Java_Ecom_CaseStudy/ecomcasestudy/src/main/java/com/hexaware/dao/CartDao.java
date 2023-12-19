package com.hexaware.dao;

import com.hexaware.entity.Cart;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The CartDao class provides methods to interact with the cart data in the database.
 * It includes operations such as adding new entries to the cart, viewing the cart by customer ID,
 * viewing the full cart, and checking if a cart, product, or customer exists.
 */
public class CartDao {
Connection connection;
Statement statement;
PreparedStatement preparedStatement;
ResultSet resultset;
/**
 * Adds a new entry to the cart.
 *
 * @param cart The Cart object representing the entry to be added.
 * @return True if the entry is added successfully; false otherwise.
 * @throws ProductNotFoundException   If the specified product is not found.
 * @throws CustomerNotFoundException  If the specified customer is not found.
 */
public boolean newCartEntry(Cart cart)  throws ProductNotFoundException, CustomerNotFoundException {
try {
if (cartExists(cart.getCartId())) {
    System.out.println("Cart with id " + cart.getCartId() + " already exists.");
    return true;
}
if (!customerExists(cart.getCustomerId())) {
System.out.println("Customer with id " + cart.getCustomerId() 
+ " does not exists.");
}
if (!productExists(cart.getProductId())) {
System.out.println("Product with id " + cart.getProductId() + " does not exists.");
}
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("insert into cart values (?,?,?,?)");
preparedStatement.setInt(1, cart.getCartId());
preparedStatement.setInt(2, cart.getCustomerId());
preparedStatement.setInt(3, cart.getProductId());
preparedStatement.setInt(4, cart.getQuantity());
int noofrows = preparedStatement.executeUpdate();
System.out.println(noofrows + " " + "item added to cart successfully");
} catch (SQLException e) {
//e.printStackTrace();
System.out.println("invalid credentials");
}
return true;
}
/**
 * Views the cart for a specific customer.
 *
 * @param cart The Cart object representing the customer whose cart is to be viewed.
 * @throws CustomerNotFoundException If the specified customer is not found.
 */
public void viewCartByCustomerId(Cart cart)throws CustomerNotFoundException {
try {
if (!customerExists(cart.getCustomerId())) {
    System.out.println("Customer with id " + cart.getCustomerId() + " does not exists.");
    return;
}
connection = DBConnUtil.getMyDBConnection();
statement = connection.createStatement();
preparedStatement = connection.prepareStatement("select c.cart_id, c.customer_id,"
+ " c.product_id, c.quantity, p.name, p.price from cart c join products p on "
+ "c.product_id = p.product_id where customer_id = ?");
preparedStatement.setInt(1, cart.getCustomerId());
resultset = preparedStatement.executeQuery();
while (resultset.next()) {
System.out.println("Cart id  : " + resultset.getInt(1));
System.out.println("Customerid  : " + resultset.getInt(2));
System.out.println("Product id :" + resultset.getInt(3));
System.out.println("Quantity :" + resultset.getInt(4));
System.out.println("Product name:" + resultset.getString(5));
System.out.println("Price :" + resultset.getInt(6));
System.out.println("------------");
}
} catch (SQLException e) {
e.printStackTrace();
}
}

/**
 * Views the full cart.
 */
public void viewFullCart() {
try {
connection = DBConnUtil.getMyDBConnection();
statement = connection.createStatement();
resultset = statement.executeQuery("select * from cart");
while (resultset.next()) {
System.out.println("Cart id:" + resultset.getInt(1));
System.out.println("Customer id:" + resultset.getInt(2));
System.out.println("Product id:" + resultset.getInt(3));
System.out.println("Quantity:" + resultset.getInt(4));
System.out.println("------"); 
}
} catch (SQLException e) {
e.printStackTrace();
}
}
/**
 * Checks if a cart with the given ID exists.
 *
 * @param cartId The ID of the cart to check.
 * @return True if the cart exists; false otherwise.
 */
public boolean cartExists(int cartId) {
try {
connection = DBConnUtil.getMyDBConnection();
preparedStatement = connection.prepareStatement("select * from cart where cart_id=?");
preparedStatement.setInt(1, cartId);
resultset = preparedStatement.executeQuery();
return resultset.next();
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}
/**
 * Checks if a product with the given ID exists.
 *
 * @param productId The ID of the product to check.
 * @return True if the product exists; false otherwise.
 * @throws ProductNotFoundException If the specified product is not found.
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
/**
 * Checks if a customer with the given ID exists.
 *
 * @param customerId The ID of the customer to check.
 * @return True if the customer exists; false otherwise.
 * @throws CustomerNotFoundException If the specified customer is not found.
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
