package leetcode.java;

import java.util.Iterator;

public class PeekingIterator_284 implements Iterator<Integer> {
  private Iterator<Integer> iter;
  private boolean hasElement;
  private Integer element;

  public PeekingIterator_284(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iter = iterator;
    this.hasElement = false;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (!hasElement) {
      element = iter.next();
      hasElement = true;
    }
    return element;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (hasElement) {
      hasElement = false;
      return element;
    }
    return iter.next();
  }

  @Override
  public boolean hasNext() {
    return hasElement || iter.hasNext();
  }
}
