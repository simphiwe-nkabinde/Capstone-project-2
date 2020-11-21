package foodQuick;

public class Main {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer();		//new customer obj and get info
		cust1.getCustomerInfo();
		Restaurant rest1 = new Restaurant();	//new restaurant obj and get info
		rest1.getRestaurantInfo();
		Meals meal1 = new Meals();				//new meals obj and get orders from customer
		meal1.setMealOrder();
		Driver dr1 = new Driver(rest1.getRestaurantLocation());		//find driver within location and create driver obj, and updates driver load
		
		
		Invoice.createInvoice(cust1, rest1, meal1, dr1);	//creates invoice
		PrintCustomers.printCustomers(cust1, meal1);	//adds new customer to customerUnordered.txt
		OrganizeFile.organizeFiles();		//organizes names taken from 'customeresUnordered.txt' and organizes them by location and alphabetical order and prints them in customersOrdered.txt

	}

}