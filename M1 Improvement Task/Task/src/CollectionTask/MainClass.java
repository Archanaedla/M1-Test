package CollectionTask;

import java.util.List;
import java.util.Map;

import entity.Food;
import entity.Type;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusinessCollectionOperation task = new BusinessCollectionOperation();
		
		System.out.println(" Print Food Based on Price High To Low");
		System.out.println(task.getFoodByPriceHighToLow(Type.NON_VEG));
		System.out.println("----------------------");
		
		System.out.println(" Print Food Based on Region");
		System.out.println(task.getFoodByAvgReview("Indian"));
		System.out.println("----------------------");
		
		System.out.println(" Print Food Based on Type & Region");
		System.out.println(task.groupFoodBasedOnTypeAndRegion());
		

	}

}
