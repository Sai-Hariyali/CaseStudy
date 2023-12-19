package com.hexaware.entity;

/**
 * The Products class represents a product in the Ecommerce system.
 * Each product has a unique identifier, name, price, description, and stock quantity.
 * 
 *<p>Usage:
 * - Used to store information about various products available in the Ecommerce system.
 * - Instances of this class can be created to represent specific products.
 * 
 *<p>Attributes:
 * - productId: Unique identifier for the product.
 * - name: Name of the product.
 * - price: Price of the product.
 * - description: Description of the product.
 * - stockQuantity: Quantity of the product available in stock.
 * 
 *<p>Constructors:
 * - Products(): Default constructor.
 * - Products(int productId, String name, int price, String description, int stockQuantity):
 *  Parameterized constructor.
 * - Products(int productId): Constructor to set only the productId.
 * 
 *<p>Methods:
 * - Getter and setter methods for each attribute.
 * - toString(): Generates a string representation of the Products object.
 * 
 *<p>@author Sai Hariyali
 *
 * @version 1.0
 * @since 2023-12-01
 */

public class Products {
private int productId;
private String name;
private int price;
private String description;
private int stockQuantity;

public int getProductId() {
return productId;
}

public void setProductId(int productId) {
this.productId = productId;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getPrice() {
return price;
}

public void setPrice(int price) {
this.price = price;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public int getStockQuantity() {
return stockQuantity;
}

public void setStockQuantity(int stockQuantity) {
this.stockQuantity = stockQuantity;
}

public Products() {
super();
// TODO Auto-generated constructor stub
}

public Products(int productId, String name, int price, String description, int stockQuantity) {
super();
this.productId = productId;
this.name = name;
this.price = price;
this.description = description;
this.stockQuantity = stockQuantity;
}

@Override
public String toString() {
return "Products [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
+ description + ", stockQuantity=" + stockQuantity + "]";
}

public Products(int productId) {
this.productId = productId;
}
}
