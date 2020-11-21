package foodQuick;

import java.util.HashSet;
import java.util.Scanner;

public class Meals {
	//fields
	String prepInstr;		//preparation instructions
	int orderNum;
	Object[] mealOrder;		//Array of objects containing individuals meal orders
	double totalOrderPrice;		//sum of total costs of individual meals
	
	//methods
	public void setMealOrder() {		//getting meal orders from user and store orders into mealOrder[]
		
		HashSet<Object> mealOrderHash = new HashSet<Object>(); 	//created for convenience of simply adding elements to collection
		Scanner order = new Scanner(System.in);
		String orderPrompt = "Please enter your order using the following format: \n meal name,price of single meal,how many of that meal";
		
		System.out.println(orderPrompt);			//request customer to order
		
		String orderInput = order.nextLine();		//store order as string
		String[] orderArr = orderInput.split(",");	//convert string to array [meal, price, #ofmeals]
		
		OrderObj first = new OrderObj(orderArr[0], orderArr[1], orderArr[2]);  //create new OrderObj
		mealOrderHash.add(first);						//add the ordered meal obj to hashSet
		
		//if customer wants to order another item
		System.out.println("Would you like to order another item? y/n");
		String orderAgain = order.nextLine();	// == "y" or "n"
		
		while (orderAgain.equals("y")) {
			System.out.println(orderPrompt);		//request customer to order
			orderInput = order.nextLine();			//store order as a string
			orderArr = orderInput.split(",");		//convert string to array [meal, price, #ofmeals]
			first = new OrderObj(orderArr[0], orderArr[1], orderArr[2]); //create an object of the order
			mealOrderHash.add(first);						//add the ordered meal obj to hashSet
			System.out.println("Would you like to order something else? y/n");
			orderAgain = order.nextLine();
		}
		mealOrder = mealOrderHash.toArray();		//convert hashSet to array and store as mealOrder(field attribute)
		
		//prepInstructions
		System.out.println("Please provide any preparation instructions you will like to be observed");  
		prepInstr = order.nextLine();
		
		//order Number
		double random = Math.random()*10000;
		orderNum = (int) Math.round(random);	//generates random number as order number
		
		//iterates through OrderObj's in mealOrder[]. sums up all individual meal totalPrices.
		for (Object i: mealOrder) {
			totalOrderPrice += ((OrderObj) i).getTotalPrice();		//gets totalPrice from each OrderObj and adds to total
		}
	}
	
//	public static void main(String[] args) {
//		Meals burger = new Meals();
//		burger.setMealOrder();
//		System.out.println(burger.orderNum);
//		System.out.println(burger.totalOrderPrice);
//		for (Object i: burger.mealOrder) {
//			System.out.println(((OrderObj) i).getTotalPrice());
//		}
//		System.out.println(burger.prepInstr);
//	}
	
}
	
