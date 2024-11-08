package assignments;

import java.util.HashMap;
import java.util.Map;

class account{
	private int no;
	private String name;
	private int balance;
	public account(int no,String name,int balance) {
		this.no=no;
		this.name=name;
		this.balance=balance;
	}
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		if(amount<=0) {
			System.out.println("enter valid amount");
		}
		else {
		balance =balance+amount;
		System.out.println("amount deposited : "+amount);
		
		System.out.println("current balance : "+balance);
		}
	}
	public void withdraw(int amount) {
		if(amount<=0) {
			System.out.println("enter a valid amount");
		}
		else if(amount>balance) {
			System.out.println("insufficient balance");
			}
		else {
			balance =balance-amount;
			System.out.println("amount withdraw : "+amount);
			System.out.println("current balance : " +balance);
		}
	}
	public String toString() {
        return "Account{" +
               "accountnumber='" + no + '\'' +
               ", name='" + name + '\'' +
               ", balance=" + balance +
               '}';
    }
}
class transaction{
  String transactiontype;
  int amount;
  account a;
  public transaction (String transactiontype,int amount,account a) {
	  this.transactiontype=transactiontype;
	  this.amount=amount;
	  this.a=a;
	  }
  public void trans() {
	  if(transactiontype.equals("deposit")) {
		  a.deposit(amount);
	  }
	  else if(transactiontype.equals("withdraw")) {
		  a.withdraw(amount);
		  
	  }
  
  }
	
	
}
class bank{
	private Map<Integer, account> accounts= new HashMap<>();

    public void createAccount(int no, String name, int initialBalance) {
      
        account a = new account(no, name, initialBalance);
        accounts.put(no, a);
        System.out.println("Account created: " + a);
    }

    
    public account getAccount(int no) {
        return accounts.get(no);
    }

   
    public void executeTransaction(int no, String transactiontype, int amount) {
        account a = getAccount(no);
      
        transaction t = new transaction(transactiontype, amount, a);
       t.trans();
    }

    
    public void displayAccountInfo(int no) {
        account a = getAccount(no);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("Account not found.");
        }
    }
	
	
}
public class bankingsystem {

	public static void main(String[] args) {
		account a = new account(10,"rajitha",10000);
		transaction t = new transaction("deposit",1000,a);
		t.trans();
		transaction t1 = new transaction("withdraw",2000,a);
		t1.trans();
		bank b =new bank();
		b.createAccount(20,"rajitha", 1000);
	    System.out.println(	b.getAccount(20));
		b.executeTransaction(20,"deposit", 100);
		

	}
}
