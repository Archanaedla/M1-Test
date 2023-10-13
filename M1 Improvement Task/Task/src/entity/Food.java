package entity;

import java.util.List;

public class Food {

	private String foodItemName;
	private int cost;
	private Type category;
	private String region;
	
	List<Review> allReviews;

	public Food(String foodItemName, int cost, Type category, List<Review> allReviews) {
		super();
		this.foodItemName = foodItemName;
		this.cost = cost;
		this.category = category;
		this.allReviews = allReviews;
	}

	public Food(String foodItemName, int cost, Type category,String region,List<Review> allReviews) {
		super();
		this.allReviews = allReviews;
		this.foodItemName = foodItemName;
		this.cost = cost;
		this.category = category;
		this.region = region;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Type getCategory() {
		return category;
	}

	public void setCategory(Type category) {
		this.category = category;
	}

	public List<Review> getAllReviews() {
		return allReviews;
	}

	public void setAllReviews(List<Review> allReviews) {
		this.allReviews = allReviews;
	}

	@Override
	public String toString() {
		return "Food [foodItemName=" + foodItemName + ", cost=" + cost + ", category=" + category + ", region=" + region
				+ ", allReviews=" + allReviews + "]";
	}
	
	
}

