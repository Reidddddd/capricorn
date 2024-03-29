package problem.tag.design.medium;

import java.util.Arrays;

/**
 * 1352. Product of the Last K Numbers
 * <p></p>
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 * <p></p>
 */
public class ProductOfNumbers {

  private int[] products;
  private int ptr;

  public ProductOfNumbers() {
    products = new int[40001];
    ptr = 0;
    products[ptr++] = 0;
  }

  public void add(int num) {
    if (num == 0) {
      Arrays.fill(products, 0, ptr++, 0);
      return;
    }

    products[ptr] = products[ptr - 1] == 0 ? num : num * products[ptr - 1];
    ptr++;
  }

  public int getProduct(int k) {
    if (ptr == 0) {
      return 0;
    }

    int lastIndex = ptr - 1;
    int last = products[lastIndex];
    int lastK = products[lastIndex - k];
    int lastKPlus = products[lastIndex - k + 1];

    return lastK == 0 ? lastKPlus == 0 ? 0 : last : last / lastK;
  }

}
