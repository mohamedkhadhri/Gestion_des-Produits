package com.tekup.produits.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	
	 private static final String URL = "jdbc:mysql://localhost:3306/products"; // Remplacez par votre base de données
	    private static final String USER = "root"; // Remplacez par votre nom d'utilisateur
	    private static final String PASSWORD = ""; // Remplacez par votre mot de passe

	    public static Connection getConnection() throws SQLException {
	        try {
	            // Charger le driver MySQL (peut ne pas être nécessaire selon votre version de JDBC)
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            throw new SQLException("Connection failed", e);
	        }
	    }

}
