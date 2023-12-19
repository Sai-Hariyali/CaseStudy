package com.hexaware.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import com.hexaware.dao.CartDao;
import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.entity.Cart;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
/**
 * This class contains unit tests for the {@link CartDao} class.
 * It focuses on testing the functionality related to new cart entries.
 * 
 * @author Sai Hariyali
 * @version 1.0
 * @since 2023-12-18
 */
public class CartDaoTest {
	 /**
     * The instance of the {@link CartDao} class to be tested.
     */
CartDao cartdao;
/**
 * The instance of the {@link OrderProcessorRepositoryImpl} class to be used in tests.
 */
OrderProcessorRepositoryImpl orderProcessorRepoImpl = new OrderProcessorRepositoryImpl();
/**
 * Initializes the necessary objects before each test case.
 */
@Before
public void setUp() {
    cartdao = new CartDao();
}
/**
 * Tests the new cart entry functionality by adding a new cart.
 * It checks whether the cart is added successfully without exceptions.
 */
  @Test
    public void testNewCartEntry() {
    int cartId = 17; 
    int productId = 20;
    int customerId = 55;
    int quantity = 4;
    Cart cart = new Cart(cartId, productId, customerId, quantity);
    try {
		cartdao.newCartEntry(cart);
	} catch (ProductNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (CustomerNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  /**
   * Cleans up resources after each test case.
   */  
@After
    public void tearDown() {
    cartdao = null;
  }
}
