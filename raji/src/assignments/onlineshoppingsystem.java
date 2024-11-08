package assignments;
import java.util.ArrayList;
import java.util.List;

class products{

	    private String id;       
	    private String name;    
	    private double price;   

	    public products(String id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	      
	    }

	    
	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public double getPrice() {
	        return price;
	    }

	   
	}


class Cart {
    private List<products> products;

    
    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(products p) {
        products.add(p);
    }

   
    public void removeProduct(products p) {
        products.remove(p);
    }

    public List<products> viewProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (products p : products) {
            total += p.getPrice();
        }
        return total;
    }


    
}


class Order {
    private List<products> p;
    private double totalAmount;

    
    public Order(List<products> p, double totalAmount) {
        this.p = p;
        this.totalAmount = totalAmount;
    }

   
    public void ordersummary() {
        System.out.println("Order Details:");
        for (products p : p) {
            System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice());
        }
        System.out.println("Total Amount: " + totalAmount);
    }


}


public class onlineshoppingsystem {
	
	
	public static void main(String[] args) {
		
		products p1=new products("10","mobile",11000);
		products p2=new products("20","laptop",40000);
		Cart c=new Cart();
		c.addProduct(p1);
		c.addProduct(p2);
		
		Order o=new Order(c.viewProducts(),c.calculateTotal());
		o.ordersummary();
		
	}
	
	

}