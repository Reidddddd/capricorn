package leetcode.java.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight_406 {
  public int[][] reconstructQueue(int[][] people) {
    int row = people.length;
    List<Tuple> pairs = new ArrayList<>(row);
    for (int i = 0; i < row; i++) pairs.add(new Tuple(people[i][0], people[i][1]));
    Collections.sort(pairs);
    List<Tuple> sorted = new LinkedList<>();
    int size = 0;
    for (Tuple pair : pairs) {
      if (pair.k >= size) sorted.add(pair);
      else sorted.add(pair.k, pair);
      size++;
    }
    int i = 0;
    for (Tuple pair : sorted) {
      people[i][0] = pair.h;
      people[i++][1] = pair.k;
    }
    return people;
  }

  class Tuple implements Comparable<Tuple> {
    int h;
    int k;
    public Tuple(int h, int k) {
      this.h = h;
      this.k = k;
    }

    @Override
    public int compareTo(Tuple o) {
      return Integer.compare(this.h, o.h) == 0 ? Integer.compare(this.k, o.k) : -Integer.compare(this.h, o.h);
    }
  }
}
