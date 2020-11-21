package foodQuick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class OrganizeFile {
	
	//organize the customer list text file.
	//groups customers according to their location
	//arranges grouped customers in alphabetical order
	
	//method
	public static void organizeFiles() {
		//variables
			//arrayLists locations
		ArrayList<String[]> cpt = new ArrayList<String[]>();	//capetown
		ArrayList<String[]> dbn = new ArrayList<String[]>();	//durban
		ArrayList<String[]> jhb = new ArrayList<String[]>();	//johannesburg
		ArrayList<String[]> potch = new ArrayList<String[]>();	//portchefstroom
		ArrayList<String[]> sprb = new ArrayList<String[]>();	//springbok
		ArrayList<String[]> bloem = new ArrayList<String[]>();	//bloemfontein
		ArrayList<String[]> pe = new ArrayList<String[]>();		//port elizabeth
		ArrayList<String[]> witb = new ArrayList<String[]>();	//witbank
			//arrays locations. array contents will be added in the toArray() method
		String[] cptA = null;
		String[] dbnA = null;
		String[] jhbA = null;
		String[] potchA = null;
		String[] sprbA = null;
		String[] bloemA = null;
		String[] peA = null;
		String[] witbA = null;
		
		String fileContent = null;
		
		try {
			//read file and retrieve customers data
			File file = new File("customerUnordered.txt");
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
				String customer = sc.nextLine();
				if (!customer.equals("")) {
					
					String[] custArr = customer.split(", ");	//convert string to array [name, order number, location]
			
					String loc = custArr[2];	//location at index 2 of custArr
					
					//add the custArr to relevant arrayList according to location
					if (loc.equals("Cape Town")) {cpt.add(custArr);}
					else if (loc.equals("Durban")) {dbn.add(custArr);}
					else if (loc.equals("Johannesburg")) {jhb.add(custArr);}
					else if (loc.equals("Potchefstroom")) {potch.add(custArr);}
					else if (loc.equals("Springbok")) {sprb.add(custArr);}
					else if (loc.equals("Bloemfontein")) {bloem.add(custArr);}
					else if (loc.equals("Port Elizabeth")) {pe.add(custArr);}
					else if (loc.equals("Witbank")) {witb.add(custArr);}
				}
					
			}
				
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occured.");
		}
		
		//convert all arrayLists to String[]		
		cptA = toArray(cpt);
		dbnA = toArray(dbn);
		jhbA = toArray(jhb);
		potchA = toArray(potch);
		sprbA = toArray(sprb);
		bloemA = toArray(bloem);
		peA = toArray(pe);
		witbA = toArray(witb);
		
		//store all Arrays in a single array
		String[][] allArr = {cptA, dbnA, jhbA, potchA, sprbA, bloemA, peA, witbA};
		
		//iterate through allArr[] and store contents into a string 
		for (String[] i: allArr) { 
			fileContent += "\n";
			for (String j: i) {
				
				fileContent += j + "\n";
			}
		}
		

		//write fileContent into cutomerOrdered.txt
		try {
			Formatter f = new Formatter("customerOrdered.txt");
			f.format("%s", fileContent);
			f.close();
		}
		catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	
	
	//METHOD
	//takes arrayList and returns String[]. Converts each arrayList element from an array to a string. sorts arrays	
	public static String[]  toArray(ArrayList<String[]> list) {
		String[] arr = new String[list.size()];
		
		//
		for (int i=0; i<list.size(); i++) {
			String[] customer = (String[]) list.get(i);
			String str = String.join(" ", customer);
			arr[i]= str;
		}
		//sort array elements alphabetically
		Arrays.sort(arr);
		return arr;
	}
	
	
}
