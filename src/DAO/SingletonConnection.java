package DAO;

import java.sql.*;

public class SingletonConnection {
private static Connection connection;
static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
	    System.out.println("connected successfully");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Connection getConnection() {
	return connection;
}
}
