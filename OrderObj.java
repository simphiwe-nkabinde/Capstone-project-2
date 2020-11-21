package foodQuick;

public class OrderObj {	//obj of individual meals
	//fields
	double price;
	int numOfMeals;			//number of the same meal ordered
	String meal;
	double totalPrice;		//price * numOfMeals
	
	//constructor
	public OrderObj (String $meal, String $price, String $numOfMeals) {
		this.meal = $meal;
		this.price = Double.parseDouble($price);	//converts string to double
		this.numOfMeals = Integer.parseInt($numOfMeals);	//converts string to integer
		this.totalPrice = price * numOfMeals;
	}
	//getters
	public double getTotalPrice() {
		return totalPrice;
	}
	

}
