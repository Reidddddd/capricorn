package leetcode.java;

public class ProductOfArrayExceptSelf_238 {
  public int[] productExceptSelf(int[] nums) {
    int[] leftProduct = new int[nums.length];
    leftProduct[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
    }
    int rightProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      leftProduct[i] *= rightProduct;
      rightProduct *= nums[i];
    }
    return leftProduct;
  }
}
