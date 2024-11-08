package assignment;

import java.awt.print.Book;

public class test {

		public static void main(String[] args) {

			
			
			book b=new book();
			System.out.println("current book count");
			b.getBookById(20);
			
			
			borrowers b1 = new borrowers(123,"rajitha");
			transactions t = new transactions();
			System.out.println("issuing book");
			t.issueBook(1100, 20, 123);
			System.out.println("book count after issuing");
			b.getBookById(20);
			System.out.println("book returned");
			t.returnBook(1100);
			b.getBookById(20);
		 	
			
			
			
			
			
			
			
			
			

		}

	}

