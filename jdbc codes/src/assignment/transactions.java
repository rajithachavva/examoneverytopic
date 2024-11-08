package assignment;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transactions {
	   private int tId;
	    private int bookId;
	    private int bId;
	    private Date issueDate;
	    private Date returnDate;

	  
	   

	 
	    public static boolean issueBook(int tId,int bookId, int bId) {
	    	String query = "INSERT INTO transact VALUES (?,?,?,CURDATE(),null)";
	    	try(Connection conn=databaseconnection.getConnection();
					PreparedStatement ps=conn.prepareStatement(query))
			{
	            ps.setInt(1, tId);
	            ps.setInt(2, bookId);
	            ps.setInt(3, bId);
	            int rowsAffected = ps.executeUpdate();

	            if (rowsAffected > 0) {
	                book book = new book();
	                
	                  int quan=book.getBookquanById(bookId);
	                    book.updatequantity(bookId, quan - 1);
	                    return true;
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return false;
	    }
	    
	    
	    public static boolean returnBook(int tId) {
	    	Connection conn = null;
	        PreparedStatement ps = null;
	        
	    	String query = "SELECT bookId FROM Transact WHERE tId = ?";
         
	    	try
			{
	    		conn = databaseconnection.getConnection();
	    		 ps = conn.prepareStatement(query);
	            ps.setInt(1, tId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                int bookId = rs.getInt("bookId");
	                String query1 = "UPDATE Transact SET returnDate = CURDATE() WHERE tId = ?";
	                
	                ps = conn.prepareStatement(query1);
	                ps.setInt(1, tId);
	                int rowsAffected = ps.executeUpdate();

	                if (rowsAffected > 0) {
	                    book book = new book();
	                    int quan=book.getBookquanById(bookId);
	                        book.updatequantity(bookId, quan + 1);
	                        return true;
	                    
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return false;
	    }}