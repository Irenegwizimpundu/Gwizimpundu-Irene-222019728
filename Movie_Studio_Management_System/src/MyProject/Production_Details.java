package MyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Production_Details {//Production_Details_Id	Budget	Marketing_Location	Production_Start_Line	Production_End_Line
	private int prdid;
	private String bgt;
	private String mktlctn;
	private String prstlin;
	private String prenlin;
	
	public Production_Details() {
	    // Default constructor
      }
	public Production_Details( int prdid, String bgt, String mktlctn, String prstlin, String prenlin) {
		super();
		this.prdid=prdid;
		this.bgt=bgt;
		this.mktlctn=mktlctn;
		this.prstlin=prstlin;
		this.prenlin=prenlin;
		}
	
	public int getPrdid() {
		return prdid;
	}
	public void setPrdid(int prdid) {
		this.prdid = prdid;
	}
	public String getBgt() {
		return bgt;
	}
	public void setBgt(String bgt) {
		this.bgt = bgt;
	}
	public String getMktlctn() {
		return mktlctn;
	}
	public void setMktlctn(String mktlctn) {
		this.mktlctn = mktlctn;
	}
	public String getPrstlin() {
		return prstlin;
	}
	public void setPrstlin(String prstlin) {
		this.prstlin = prstlin;
	}
	public String getPrenlin() {
		return prenlin;
	}
	public void setPrenlin(String prenlin) {
		this.prenlin = prenlin;
	}

    public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Production_Details (Budget, Marketing_Location, Production_Start_Line, Production_End_Line) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	       preparedStatement.setString(1, this.bgt);
	       preparedStatement.setString(2, this.mktlctn);
	       preparedStatement.setString(3, this.prstlin);
	       preparedStatement.setString(4, this.prenlin);
	       
	       
	       // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/movie_studio_mgt_system";
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM Production_Details";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputprdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE  Production_Details SET Budget=?	Marketing_Location=?	Production_Start_Line=?	Production_End_Line=?   WHERE Production_Details_Id = ?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	    	  stm.setString(1, this.getBgt());
	          stm.setString(2, this.getMktlctn());
	          stm.setString(3, this.getPrstlin());
	          stm.setString(4, this.getPrenlin());
	           // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputprdid);
	          
	        
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputprdid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Production_Details WHERE  Production_Details_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputprdid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}




