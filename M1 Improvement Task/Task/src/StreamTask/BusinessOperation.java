package StreamTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.Food;
import entity.Review;
import entity.Type;

public class BusinessOperation {

	List<Food> allFoods;
	public BusinessOperation() {
		allFoods = new ArrayList<>();
		
		List<Review> reviewList1 = Arrays.asList(
				new Review("A", 4, "Good"),
				new Review("B", 2, "Not good"),
				new Review("C", 4, "Good"));
		List<Review> reviewList2 = Arrays.asList(
				new Review("A", 5, "Good"),
				new Review("B", 1, "Not good"),
				new Review("C", 3, "Good"),
				new Review("D", 4, "very Good"),
				new Review("E", 5, "nice"));
		
		List<Review> reviewList3 = Arrays.asList(
				new Review("A", 4, "Good"),
				new Review("B", 1, "Not good"));
		
		
		allFoods.add(new Food("Dal Rice",150,Type.VEG,"Indian",reviewList1));
		allFoods.add(new Food("Veg Noodles",200,Type.VEG,"Asian",reviewList2));
		allFoods.add(new Food("Mix Veg",150,Type.VEG,"Indian",reviewList2));
		allFoods.add(new Food("Veg Soup",120,Type.VEG,"Europe",reviewList3));
		allFoods.add(new Food("Tandori Bread",50,Type.VEG,"Middle East",reviewList3));
		
		allFoods.add(new Food("Chicken Tikka",320,Type.NON_VEG,"Indian",reviewList2));
		allFoods.add(new Food("Chicken Biryani",420,Type.NON_VEG,"Indian",reviewList2));
		allFoods.add(new Food("Fish Curry",480,Type.NON_VEG,"Indian",reviewList1));
		allFoods.add(new Food("Chicken Pasta",320,Type.NON_VEG,"Italian",reviewList3));
		
	}
	/* You cannot change the constructor code & avgCostByCategory() signature
	 * Below method is used to filter foods based on type(veg or non-veg)and then calculate the
	 * avg price 
	 * Hint : apply .mapToInt(Food::getCost).average()
	 * */
	public int avgCostByCategory(Type category) {
		/*use stream api only*/
	 
		return (int)allFoods.stream().filter((e)->{
			if(e.getCategory() == category) return true;
			else return false;
		}).mapToInt(Food::getCost).average().orElse(0.0);
		
		 
	}
	
	/* You cannot change the constructor code & increaseCostOfFoodByRegion() signature
	 * Below method is used to filter foods based on region and then 
	 * increase the food cost by 20%;
	 * return the list of food items updated
	 * Code to be done through Stream API
	 * */
	public List<Food> increaseCostOfFoodByRegion(String filterRegion)
	{
		 
		return allFoods.stream()
	            .filter(food -> food.getRegion().equalsIgnoreCase(filterRegion))
	            .map(food -> {
	                food.setCost((int) (food.getCost() * 1.20));
	                return food;
	            })
	            .collect(Collectors.toList());
			
		 
	}
	
	/*
	 * method should return the Map<String,Integer> , where String key as foodItem name
	 * and integer value of total count of reviews
	 * 
	 * */
	public Map<String, Integer> getFoodDetails()
	{
		Map<String, Integer> detailMap = new HashMap<>();

	    allFoods.stream()
	            .flatMap(food -> food.getAllReviews().stream())
	            .forEach(review -> {
	                String foodItemName = review.getUsername();
	                detailMap.put(foodItemName, detailMap.getOrDefault(foodItemName, 0) + 1);
	            });

	    return detailMap;

}
}


