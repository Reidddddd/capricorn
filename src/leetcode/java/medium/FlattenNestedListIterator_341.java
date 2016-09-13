package leetcode.java.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 implements Iterator<Integer> {

  interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  private Iterator<NestedInteger> iter;
  private NestedInteger nestedInteger;
  private Stack<Iterator<NestedInteger>> stack;

  public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();
    this.iter = nestedList.iterator();
  }

  @Override
  public boolean hasNext() {
    if (iter.hasNext()) {
      nestedInteger = iter.next();
      if (nestedInteger.isInteger()) return true;
      stack.push(iter);
      iter = nestedInteger.getList().iterator();
      return hasNext();
    } else {
      if (!stack.isEmpty()) {
        iter = stack.pop();
        return hasNext();
      }
    }
    return false;
  }

  @Override
  public Integer next() {
    return nestedInteger.getInteger();
  }
}
