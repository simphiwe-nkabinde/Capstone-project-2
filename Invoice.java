package foodQuick;

import java.util.Formatter;

public class Invoice {
	
	//method
	//takes all 4 main class objects that will have been created as arguments
	public static void createInvoice(Customer customer,Restaurant restaurant, Meals meals, Driver driver) {
		
		String order = "";
		//iterates through mealOrder objs and stores meal order details as string in 'order' variable
		for (Object i: meals.mealOrder) {
			String str = "\n" + ((OrderObj) i).numOfMeals + " x " + ((OrderObj)i).meal + " (R" + ((OrderObj)i).price + ")";
			order += str;
		}
		//content of invoice
		String content = 
				"Order number: " + meals.orderNum +
				"\nCustomer: " + customer.name +
				"\nEmail: " + customer.email +
				"\nPhone number: " + customer.contactNum +
				"\nLocation: " + customer.location +
				
				"\n\nYou have ordered the following from " + restaurant.name + " in " + restaurant.location + ":" +
				"\n" + order +
				"\n\nSpecial instructions: " + meals.prepInstr + 
				"\n\nTotal: R" + meals.totalOrderPrice + 
				
				"\n\n" + driver.name + " is nearest to the restaurant and so he will be delivering your order to you at:" +
				"\n\n" + customer.address + 
				"\n" + customer.location + 
				"\n\nIf you need to contact the restaurant, their number is " + restaurant.contactNum + ".";
		

		//write invoice file
		try {
			Formatter f = new Formatter("invoice.txt");
			f.format("%s", content);
			f.close();
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
	}
}
