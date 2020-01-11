/**
 * 
 */
package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;

/**
 * @author ok
 *
 */
public class DBHandler {

	private static Connection conn = null;
	private static Statement stmt = null;
	
	public DBHandler()
	{
		createConnection();
	}
	
	static void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/ucm_supplier_app","root", "");
				//System.out.print("Database is connected !");
				//conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static ResultSet execQuery(String query)
	{
		ResultSet result = null;
		createConnection();
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("here is the error");
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static boolean execAction(String qu, String message)
	{
		createConnection();
		try {
			stmt = conn.createStatement();
			stmt.execute(qu);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	
	public static void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

