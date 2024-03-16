package problem.tag.design.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 901. Online Stock Span
 * <p></p>
 * https://leetcode.com/problems/online-stock-span/
 * <p></p>
 */
public class StockSpanner {

  private List<Integer> stocks;
  private List<Integer> spans;

  public StockSpanner() {
    stocks = new ArrayList<>();
    spans = new ArrayList<>();
  }

  public int next(int price) {
    int span = 1;
    try {
      if (spans.isEmpty()) {
        spans.add(span);
        return span;
      }

      int index = stocks.size() - 1;
      while (index >= 0) {
        if (price < stocks.get(index)) {
          spans.add(span);
          return span;
        }

        span += spans.get(index);
        index -= spans.get(index);
      }
    } finally {
      stocks.add(price);
    }
    spans.add(span);
    return span;
  }

}
