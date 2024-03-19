package problem.tag.design.medium;

import java.util.Iterator;

/**
 * 284. Peeking Iterator
 * <p></p>
 * https://leetcode.com/problems/peeking-iterator/
 * <p></p>
 */
public class PeekingIterator implements Iterator<Integer> {

  private Iterator<Integer> iterator;
  private int peek;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    this.peek = -1;
  }

  public Integer peek() {
    if (peek == -1) {
      peek = iterator.next();
      return peek;
    }
    return peek;
  }

  @Override
  public Integer next() {
    if (peek != -1) {
      int next = peek;
      peek = -1;
      return next;
    }

    return iterator.next();
  }

  @Override
  public boolean hasNext() {
    if (peek != -1) {
      return true;
    }
    return iterator.hasNext();
  }

}
