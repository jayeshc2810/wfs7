/**
 * 
 */
package com.hsbc.pkg;

import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Jayesh
 *
 */

class Customer implements Comparable<Customer>,Serializable {
	String custName,custAddr;
	ArrayList<String> prodList;
	int prodPrice;
	
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custAddr=" + custAddr + ", prodList=" + prodList + ", prodPrice="
				+ prodPrice + "]";
	}

	public Customer() {
		super();
	}
	
	public Customer(ArrayList<String> prodList) {
		this.prodList = prodList;
	}
	
	public Customer(String custName) {
		this.custName = custName;
	}
	
	public Customer(String custName, String custAddr, ArrayList<String> prodList,int prodPrice) {
		super();
		this.custName = custName;
		this.custAddr = custAddr;
		this.prodList = prodList;
		this.prodPrice = prodPrice;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		if(prodPrice < this.prodPrice)
			return 1;
		else if(prodPrice > this.prodPrice)
			return -1;
		else
		  return 0;
	}
}

public class CustomerPortal {

	static Scanner sc = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer> ct = new ArrayList<Customer>();
		char cOpt = 'Y';
		while(cOpt=='Y') {
				System.out.println("******************************************************");
				System.out.println("Welcome to BuyHere!!");
				System.out.println("******************************************************");
				System.out.println("Enter your details and the product you want!!It will be added to your cart ahead during payment automatically!!");
				System.out.print("Enter your Name : ");
				String custName = sc.next();
				Customer c = new Customer(custName);
				System.out.print("Enter your Address : ");
				c.custAddr = sc.next();
				char pOpt = 'Y';
				while(pOpt=='Y') {
					c.prodList = new ArrayList<String>();
					System.out.print("Enter the Product Name : ");
					String pname = sc.next();
					c.prodList.add(pname);
					System.out.print("Enter the Product Price : ");
					int prodPrice = sc.nextInt();
					c.prodPrice += prodPrice;
					System.out.println("******************************************************");
					System.out.println("Congratulations!!You have successfully added the product!!");
					System.out.println("******************************************************");
					System.out.println("Would you like to add more products?(Y/N) : ");
					pOpt = sc.next().charAt(0);
			    }
			System.out.println("******************************************************");
			System.out.println("Would you like to add more customers?(Y/N) : ");
			cOpt = sc.next().charAt(0);
			ct.add(c);
		}
		Collections.sort(ct);
		Collections.reverse(ct);
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\jayes\\OneDrive\\Desktop\\custdata.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Customer cs : ct)
				oos.writeObject(cs);
			oos.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
