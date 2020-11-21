package foodQuick;

import java.util.Scanner;
//customer class for creating customer object and get info about customer
public class Customer {
	//fields
	String name;
	String contactNum;
	String address;
	String location;
	String email;
	
	//method
	public void getCustomerInfo() { 	//request and store info about customer
		Scanner customer = new Scanner(System.in);		//create scanner object
		System.out.println("Good day. To user the FoodQuick service please provide the following personal informatio:");
		
		System.out.print("Name: ");
		name = customer.nextLine();
		
		System.out.print("Contact Number: ");
		contactNum = customer.nextLine();
		
		System.out.print("Address: ");
		address = customer.nextLine();
		
		System.out.print("Location: ");
		location = customer.nextLine();
		
		System.out.print("Email: ");
		email = customer.nextLine();
		
	}
	
//	public static void main(String[] args) {
//		Customer sam = new Customer();
//		sam.getCustomerInfo();
//		System.out.println(sam.name);
//		System.out.println(sam.address);
//		System.out.println(sam.contactNum);
//		System.out.println(sam.email);
//		System.out.println(sam.location);
//	}
	
}
