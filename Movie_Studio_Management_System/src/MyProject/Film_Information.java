package MyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Film_Information {//Film_Info_Id	Actor_Id	Director_Id	Title	Duration	Release_Date	

	private int flminfoid;
	private String actid;
	private String dirctid;
	private String title;
	private String duration;
	private String relsdate;
	
	public Film_Information(int flminfoid,String actid,String dirctid,String title,String duration,String relsdate ) {
	    // Default constructor
      }
	public Film_Information() {
		super();
		this.flminfoid=flminfoid;
		this.actid=actid;
		this.dirctid=dirctid;
		this.title=title;
		this.duration=duration;
		this.relsdate=relsdate;
		}
	
    public int getFlminfoid() {
		return flminfoid;
	}
	public void setFlminfoid(int flminfoid) {
		this.flminfoid = flminfoid;
	}
	public String getActid() {
		return actid;
	}
	public void setActid(String actid) {
		this.actid = actid;
	}
	public String getDirctid() {
		return dirctid;
	}
	public void setDirctid(String dirctid) {
		this.dirctid = dirctid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRelsdate() {
		return relsdate;
	}
	public void setRelsdate(String relsdate) {
		this.relsdate = relsdate;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Film_Information (Actor_Id, Director_Id,	Title,	Duration,	Release_Date) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	       preparedStatement.setString(1, this.actid);
	       preparedStatement.setString(2, this.dirctid);
	       preparedStatement.setString(3, this.title);
	       preparedStatement.setString(4, this.duration);
	       preparedStatement.setString(5, this.relsdate);
	       
	     
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

		        String sql = "SELECT * FROM Film_Information";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }

	public void update(int inputflminfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE  Film_Information SET Actor_Id=?, Director_Id=?,	Title=?, Duration=?, Release_Date=?   WHERE Film_Info_Id = ?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	    	  stm.setString(1, this.getActid());
	          stm.setString(2, this.getDirctid());
	          stm.setString(3, this.getTitle());
	          stm.setString(4, this.getDuration());
	          stm.setString(5, this.getRelsdate()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputflminfoid);
	       
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
	public void delete(int inputflminfoid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/movie_studio_mgt_system";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Film_Information WHERE  Film_Info_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputflminfoid); // Assuming there is a column named 'id' for the WHERE clause

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








