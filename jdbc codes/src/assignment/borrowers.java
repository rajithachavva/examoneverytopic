package assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrowers {
	
	    private int bId;
	    private String name;
	   
	   
	    public borrowers(int bId, String name) {
	     this.bId=bId;
	     this.name=name;
	    }

	    public int getBorrowerId() {
	        return bId;
	    }


	    public String getName() {
	        return name;
	    }

	    public static boolean addBorrower(int bId, String name) {
	    	String query = "INSERT INTO Borrowers VALUES (?, ?)";
	        try(Connection conn=databaseconnection.getConnection();
					PreparedStatement ps=conn.prepareStatement(query))
			{
	          
	           
	            ps.setInt(1, bId);
	            ps.setString(2, name);
	            int rowsAffected = ps.executeUpdate();
	            return rowsAffected > 0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return false;
	    }
	    
	    
	}


