package problem.tag.design.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1357. Apply Discount Every n Orders
 * <p></p>
 * https://leetcode.com/problems/apply-discount-every-n-orders/
 * <p></p>
 */
public class Cashier {

  private int n;
  private int checkOuted;
  private int discount;
  private Map<Integer, Product> products;

  public Cashier(int n, int discount, int[] products, int[] prices) {
    this.n = n;
    this.checkOuted = 0;
    this.discount = discount;
    this.products = new HashMap<>();

    int i = 0;
    for (; i < prices.length; i++) {
      this.products.put(products[i], new Product(prices[i]));
    }
  }

  public double getBill(int[] product, int[] amount) {
    int i = 0;
    double bill = 0.0;

    for (; i < product.length; i++) {
      bill += products.get(product[i]).price * amount[i];
    }

    if (checkOuted == n - 1) {
      checkOuted = 0;
      return bill * (100 - discount) / 100;
    }
    checkOuted++;
    return bill;
  }

  class Product {
    int price;

    public Product(int price) {
      this.price = price;
    }
  }

}
