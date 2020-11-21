package foodQuick;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintCustomers {

	public static void printCustomers(Customer customer, Meals meal) {
		
		String name = customer.name;
		int orderNum = meal.orderNum;
		String location = customer.location;
		
		try(FileWriter fw = new FileWriter("customerUnordered.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);) {
			out.println(name + ", " + orderNum + ", " + location);
		}	catch (IOException e ) {
			e.printStackTrace();
		}
	}
}
