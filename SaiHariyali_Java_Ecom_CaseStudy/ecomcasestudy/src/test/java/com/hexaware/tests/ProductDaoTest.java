package com.hexaware.tests;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.dao.ProductDao;
import com.hexaware.entity.Products;
/**
 * This is a JUnit test class for the ProductDao class.
 * It includes test cases related to creating products.
 */
public class ProductDaoTest {
	/** The ProductDao instance to be tested. */
ProductDao productdao;
/** The OrderProcessorRepositoryImpl instance for additional testing. */
OrderProcessorRepositoryImpl orderProcessorRepoImpl = new OrderProcessorRepositoryImpl();
/**
 * Sets up the necessary objects before each test case.
 */
@Before
public void setUp() {
productdao = new ProductDao();
}
/**
 * Tests the creation of a product using the createProduct method.
 */
@Test
public void testCreateProduct(){
int productId = 18;
String productName = "Test Product";
int price = 50;
String description = "Test Description";
int stockQuantity = 10;
Products products = new Products(productId, productName, price, description, stockQuantity);    
products.setProductId(productId);
   products.setName(productName);
   products.setPrice(price);
   products.setDescription(description);
   products.setStockQuantity(stockQuantity);
   assertTrue(orderProcessorRepoImpl.createProduct(products));

}
/**
 * Tears down the objects after each test case.
 */
@After
public void tearDown() {
productdao = null;
}
}
