/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.sql.*;

public class ConnectionManager {
    static final String URL = "jdbc:mysql://localhost:3306/saikyotaekyondo?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "";
    private static Connection connection=null;
    
    public ConnectionManager(){}
    
    private static Connection makeConnection( )throws SQLException {
   try {
      //Class.forName( driver );
	   // load the database driver class
	   connection = DriverManager.getConnection( URL, USER, PASSWORD );
	} catch ( SQLException ex ) {
		System.out.print("connection error"+ex.toString() ); // Logging
		throw new SQLException( ex );
        } 
   return connection;
 }
    
    public static Connection getConnection() throws SQLException {
	if ( connection == null ) connection = makeConnection();
	return connection;
 }
}