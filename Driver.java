package foodQuick;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Driver {
	//fields
	String name;
	String location;
	String load;
	
	//constructor 
	public Driver(String rLocation) {		//takes restaurant location as argument
		String[] dr = findDriver(rLocation);	//finds driver of the same location as restaurant form drivers.txt
		this.name = dr[0];						//from array of driver info
		this.location = dr[1];			
		this.load = dr[2]; 					
	}
	
	//method
	static public String[] findDriver(String restLocation) {	//finds a driver from driver.txt with same location as restaurant argument 
		String[] dataArr = null;
		ArrayList<String> allDrivers = new ArrayList<String>();
		String driversFile = "";
		String[] chosenDriver = null;
		
		//READ driver.txt file
		try {
			File drivers = new File("driver-info.txt");				//read file
			Scanner sc = new Scanner(drivers);
			while (sc.hasNextLine()) {		
				String data = sc.nextLine();	//stores string read by scanner
				dataArr = data.split(", ");	//string to Array [name, location, load]
				
					//content to be written on drivers.txt
				if (dataArr[1].equals(restLocation)) {		//compare driver's location to restaurant's location
					
					if (chosenDriver == null) {
						//UPDATE DRIVER LOAD
						//increment drivers load
						int load = Integer.parseInt(dataArr[2]) + 1;
						dataArr[2] = Integer.toString(load);
						chosenDriver = dataArr;
						String newString =  String.join(", ", dataArr);
						//add Strings to Arr
						allDrivers.add(newString);
						
					}					
				}
				else {	//add all other strings to the array
					allDrivers.add(data);
				}
				
			}
			//iterate through allDrivers array to form a string
			for (String i: allDrivers) {
				driversFile += i + "\n";
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occured."); 
		}
		
		//OVERWRITE drivers.txt with updated content
		try {
			Formatter f = new Formatter("driver-info.txt");
			f.format("%s", driversFile);
			f.close();
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
		//if locations match, that driver's info is returned as Array
		if (chosenDriver != null) {return chosenDriver;}	
		
		//if dataArr is not returned. write error message on invoice.txt file
		try {
			Formatter f = new Formatter("invoice.txt");
			f.format("%s", "Sorry! Our drivers are too far away from you to be able to deliver to your location.");
			f.close();
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		Driver find = new Driver("Bloemfontein");
//		System.out.println(find.name);
//		System.out.println(find.location);
//		System.out.println(find.load);
//		
//	}

}
