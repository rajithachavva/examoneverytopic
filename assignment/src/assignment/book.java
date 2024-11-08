package assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class book {
	public static boolean updatequantity(int bookId, int newQuantity) {
		 String query = "UPDATE Books SET quantity = ? WHERE bookid = ?";
		        try(Connection conn=databaseconnection.getConnection();
						PreparedStatement ps=conn.prepareStatement(query))
				{
		            
		            ps.setInt(1, newQuantity);
		            ps.setInt(2, bookId);
		            
		            int rowsAffected = ps.executeUpdate();
		            return rowsAffected > 0;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		        return false;
		    }

		    
		    public book getBookById(int bookId) {
		    	String query = "SELECT * FROM Books WHERE bookid = ?";
		       
		     
		        
		        try(Connection conn=databaseconnection.getConnection();
						PreparedStatement ps=conn.prepareStatement(query))
				{
		            
		            
		          ps.setInt(1, bookId);
		           ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		            	  System.out.println("bookid : "+rs.getInt("bookid"));
			                System.out.println("booktitle :"+rs.getString("title"));
			                System.out.println("bookquantity :"+rs.getInt("quantity"));
			                
		            }
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
				return null;
				
		        
		    }
		    public int getBookquanById(int bookId) {
		    	String query = "SELECT * FROM Books WHERE bookid = ?";
		       
		        
		        
		        try(Connection conn=databaseconnection.getConnection();
						PreparedStatement ps=conn.prepareStatement(query))
				{
		            
		            
		          ps.setInt(1, bookId);
		           ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		            	
		                return rs.getInt("quantity");
		                
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
				return 0;
			
			
			
	        
	    }
		}

