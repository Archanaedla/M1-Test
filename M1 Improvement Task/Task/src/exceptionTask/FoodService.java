package exceptionTask;

import java.util.Arrays;

import entity.Food;

public class FoodService {

	String region[] = {"Indian","Middle East","Europe","Italian","Asian"};
	
	/*
	 * Create a method to validate food object
	 * while creating new food.
	 * Food name is required field if not then throw null pointer exception
	 * Food cost should be greater than 10/- and less than 1500/- 
	 * Food region should belongs to any value of the region array otherwise throw InvalidFoodRegionException
	 * Reviews of food should be null
	 * 
	 * if all above requirements fulfill then return the food object otherwise
	 * throw InvalidFoodException with the msg include propertyName which leads an exception 
	 * */
	public Food validateFood(Food food)throws InvalidFoodDetailsException,InvalidFoodRegionException
	{
		if (food.getFoodItemName() == null || food.getFoodItemName().isEmpty()) {
	        throw new NullPointerException();
	    } 
		if (food.getCost() < 10 || food.getCost() > 1500) {
	        throw new InvalidFoodDetailsException("Food cost should be between 10 and 1500.");
	    } 
		if (!Arrays.asList(region).contains(food.getRegion())) {
	        throw new InvalidFoodRegionException("Invalid food region.");
	    } 
		if (food.getAllReviews() != null) {
	        throw new InvalidFoodDetailsException("Reviews of food should be null.");
	    }

	    return food;
	}
	
	
}
