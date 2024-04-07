package problem.tag.design.medium;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 2353. Design a Food Rating System
 * <p></p>
 * https://leetcode.com/problems/design-a-food-rating-system/
 * <p></p>
 */
public class FoodRatings {

  private HashMap<String, Food> foodMap;
  private HashMap<String, TreeMap<Food, Byte>> cuisineMap;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    foodMap = new HashMap<>(foods.length);
    cuisineMap = new HashMap<>();
    for (int i = 0; i < foods.length; i++) {
      Food food = new Food(foods[i], cuisines[i], ratings[i]);
      foodMap.put(food.name, food);
      cuisineMap.putIfAbsent(cuisines[i], new TreeMap<>());
      cuisineMap.get(cuisines[i]).put(food, (byte) 0);
    }
  }

  public void changeRating(String food, int newRating) {
    Food f = foodMap.get(food);
    TreeMap<Food, Byte> cuisineRate = cuisineMap.get(f.cuisine);
    cuisineRate.remove(f);

    f.updateRating(newRating);
    cuisineRate.put(f, (byte) 0);
  }

  public String highestRated(String cuisine) {
    return cuisineMap.get(cuisine).firstKey().name;
  }

  class Food implements Comparable<Food> {
    String name;
    String cuisine;
    int rating;

    Food(String name, String cuisine, int rating) {
      this.name = name;
      this.cuisine = cuisine;
      this.rating = rating;
    }

    public void updateRating(int newRating) {
      rating = newRating;
    }

    @Override
    public int compareTo(Food o) {
      int ratRes = o.rating - this.rating;
      return ratRes == 0 ? name.compareTo(o.name) : ratRes;
    }
  }

}
