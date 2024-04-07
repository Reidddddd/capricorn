package problem.tag.design.medium;

import java.util.TreeMap;

/**
 * 2034. Stock Price Fluctuation
 * <p></p>
 * https://leetcode.com/problems/stock-price-fluctuation/
 * <p></p>
 */
public class StockPrice {

  private TreeMap<Counter, Counter> minMax;
  private TreeMap<Integer, Integer> stocks;

  public StockPrice() {
    minMax = new TreeMap<>();
    stocks = new TreeMap<>();
  }

  public void update(int timestamp, int price) {
    Integer oldPrice = stocks.put(timestamp, price);

    // n for new, update new price as well
    Counter n = minMax.get(new Counter(price));
    if (n == null) {
      n = new Counter(price);
      minMax.put(n, n);
    } else {
      n.inc();
    }

    if (oldPrice == null) {
      return;
    }

    // o for old, this price happens before
    Counter o = minMax.get(new Counter(oldPrice));
    o.dec();
    if (o.canRemove()) {
      minMax.remove(o);
    }
  }

  public int current() {
    return stocks.floorEntry(Integer.MAX_VALUE).getValue();
  }

  public int maximum() {
    return minMax.lastKey().price;
  }

  public int minimum() {
    return minMax.firstKey().price;
  }

  class Counter implements Comparable<Counter> {
    int price;
    int counter;

    Counter(int price) {
      this.price = price;
      this.counter = 1;
    }

    void inc() {
      counter++;
    }

    void dec() {
      counter--;
    }

    boolean canRemove() {
      return counter == 0;
    }

    @Override
    public int hashCode() {
      return price;
    }

    @Override
    public boolean equals(Object obj) {
      Counter other = (Counter) obj;
      return other.price == this.price;
    }

    @Override
    public int compareTo(Counter o) {
      return Integer.compare(this.price, o.price);
    }
  }

}
