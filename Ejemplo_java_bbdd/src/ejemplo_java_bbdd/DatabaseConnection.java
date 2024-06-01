package ejemplo_java_bbdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Susanna
 */
    public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/BBDDEXAMEN";
    private static final String USER = "Susanna";
    private static final String PASSWORD = "101010";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
       
}



