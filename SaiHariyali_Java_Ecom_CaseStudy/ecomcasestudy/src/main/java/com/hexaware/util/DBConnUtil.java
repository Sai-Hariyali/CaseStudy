package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBConnUtil is a utility class for establishing a database connection.
 * It reads the database connection properties from a properties file 
 * and provides a method to get a connection.
 * 
 *<p>Usage:
 * - Call the getMyDBConnection() method to obtain a connection to the configured database.
 * 
 *<p>Dependencies:
 * - db.properties - Configuration file containing database connection details.
 */

public class DBConnUtil {
static Connection connection;

public static Connection getMyDBConnection() {
String fileName = "db.properties";
Properties properties = new Properties();
FileInputStream fileInputStream = null;
try {
fileInputStream = new FileInputStream(fileName);
properties.load(fileInputStream);
String url = properties.getProperty("db.url");
String username = properties.getProperty("db.username");
String password = properties.getProperty("db.password");
connection =  DriverManager.getConnection(url, username, password);
} catch (SQLException e) {
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return connection;
}

public static void main(String[] args) {
System.out.println(getMyDBConnection());
}
}
