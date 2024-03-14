package problem.tag.design.easy;

/**
 * 705. Design HashSet
 * <p></p>
 * https://leetcode.com/problems/design-hashset/
 * <p></p>
 */
public class MyHashSet {

  private boolean[] arr;

  public MyHashSet() {
    arr = new boolean[1000001];
  }

  public void add(int key) {
    arr[key] = true;
  }

  public void remove(int key) {
    arr[key] = false;
  }

  public boolean contains(int key) {
    return arr[key];
  }

}
