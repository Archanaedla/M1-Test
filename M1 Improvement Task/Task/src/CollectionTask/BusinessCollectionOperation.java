package CollectionTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import entity.Food;
import entity.Review;
import entity.Type;

public class BusinessCollectionOperation {

    List<Food> allFoods;

    public BusinessCollectionOperation() {
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

        allFoods.add(new Food("Tamato Rice", 150, Type.VEG, "Indian", reviewList1));
        allFoods.add(new Food("veg Noodles", 200, Type.VEG, "Asian", reviewList2));
        allFoods.add(new Food(" khaju Rice", 150, Type.VEG, "Indian", reviewList2));
        allFoods.add(new Food("Tamato Soup", 120, Type.VEG, "Europe", reviewList3));
        allFoods.add(new Food("Panner Bread", 50, Type.VEG, "Middle East", reviewList3));
        allFoods.add(new Food("veg pizza", 250, Type.VEG, "Middle East", reviewList3));
        allFoods.add(new Food("veg Biryani", 550, Type.VEG, "Italian", reviewList3));
        allFoods.add(new Food("Aloo Fries", 550, Type.VEG, "Europe", reviewList3));

        allFoods.add(new Food("Chicken kebab", 320, Type.NON_VEG, "Indian", reviewList2));
        allFoods.add(new Food("Chicken Biryani", 420, Type.NON_VEG, "Indian", reviewList2));
        allFoods.add(new Food("Chicken Curry", 480, Type.NON_VEG, "Indian", reviewList1));
        allFoods.add(new Food("Chicken Mandi", 320, Type.NON_VEG, "Italian", reviewList3));
        allFoods.add(new Food("Chicken Pizza", 820, Type.NON_VEG, "Italian", reviewList1));
        allFoods.add(new Food("Chicken - Tikka", 820, Type.NON_VEG, "Middle East", reviewList2));
    }

    /*
     * method is used to sort the food items based on food type
     * food has higher cost, should be the first item in the list 
     */
    public List<Food> getFoodByPriceHighToLow(Type foodType) {
        List<Food> filteredFoods = allFoods.stream()
                .filter(food -> food.getCategory() == foodType)
                .sorted(Collections.reverseOrder(Comparator.comparing(Food::getCost)))
                .collect(Collectors.toList());
        return filteredFoods;
    }

    /*
     * method will return the average review sorted by FoodName
     * filtered by region
     * String : food item name
     * Float : average review ratings
     */
    public Map<String, Float> getFoodByAvgReview(String region) {
        Map<String, Float> avgReviewMap = new HashMap<>();
        List<Food> filteredFoods = allFoods.stream()
                .filter(food -> food.getRegion().equals(region))
                .collect(Collectors.toList());
        for (Food food : filteredFoods) {
            List<Review> reviews = food.getAllReviews();
            float avgRating = (float) reviews.stream()
                    .mapToInt(Review::getRating)
                    .average()
                    .orElse(0);
            avgReviewMap.put(food.getFoodItemName(), avgRating);
        }
        return avgReviewMap;
    }

    /*
     * method should return a Map<Type,Map<String, List<Food>>>
     * where Type is Food type enum for Veg and Non Veg
     * String will hold the value of region
     * which consist all food items based on region
     */
    public Map<Type, Map<String, List<Food>>> groupFoodBasedOnTypeAndRegion() {
        Map<Type, Map<String, List<Food>>> groupedFoodMap = new HashMap<>();
        for (Type type : Type.values()) {
            Map<String, List<Food>> regionFoodMap = new HashMap<>();
            for (Food food : allFoods) {
                if (food.getCategory() == type) {
                    String region = food.getRegion();
                    List<Food> regionFoods = regionFoodMap.getOrDefault(region, new ArrayList<>());
                    regionFoods.add(food);
                    regionFoodMap.put(region, regionFoods);
                }
            }
            groupedFoodMap.put(type, regionFoodMap);
        }
        return groupedFoodMap;
    }
}