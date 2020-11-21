package foodQuick;

import java.util.Scanner;
//restaurant class to create restaurant object and 
public class Restaurant {
	//fields
	String name;
	String location;
	String contactNum;
	
	//method
	public void getRestaurantInfo() {		//request and store info about restaurant
		Scanner restaurant = new Scanner(System.in);		//create scanner object
		System.out.println("please provide details of the restaurant you would like to order from");
		
		System.out.print("Name of Restaurant: ");
		name = restaurant.nextLine();
		
		System.out.print("restaurant location: ");
		location = restaurant.nextLine();
		
		System.out.print("restaurant contact number: ");
		contactNum = restaurant.nextLine();
		
	}
		//getters
	public String getRestaurantLocation() {
		return location;
	}
	public String getRestaurantName() {
		return name;
	}
	public String getRestaurantContactNum() {
		return contactNum;
	}
	
	
//	public static void main(String[] args) {
//		Restaurant pizza = new Restaurant();
//		pizza.getRestaurantInfo();
//		System.out.println(pizza.name);
//		System.out.println(pizza.contactNum);
//		System.out.println(pizza.location);
//	}

}
