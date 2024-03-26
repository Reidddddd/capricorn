package problem.tag.design.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2502. Design Memory Allocator
 * <p></p>
 * https://leetcode.com/problems/design-memory-allocator/
 * <p></p>
 */
public class Allocator {

  private int[] freeMem;
  private int remaining;
  private Map<Integer, Set<Mem>> allocated;

  public Allocator(int n) {
    freeMem = new int[n];
    Arrays.fill(freeMem, -1);
    remaining = n;
    allocated = new HashMap<>();
  }

  public int allocate(int size, int mID) {
    if (size > remaining) {
      return -1;
    }

    for (int i = 0; i < freeMem.length; i++) {
      if (freeMem[i] == -1) {
        if (tryToAllocate(size, i)) {
          allocated.putIfAbsent(mID, new HashSet<>());
          allocated.get(mID).add(new Mem(i, size, freeMem));
          remaining -= size;
          return i;
        }
      }
    }
    return -1;
  }

  private boolean tryToAllocate(int size, int i) {
    for (int j = i; j < i + size; j++) {
      if (j == freeMem.length || freeMem[j] != -1) {
        return false;
      }
    }
    return true;
  }

  public int free(int mID) {
    if (!allocated.containsKey(mID)) {
      return 0;
    }

    int free = 0;
    Set<Mem> mem = allocated.remove(mID);
    for (Mem m : mem) {
      remaining += m.free();
      free += m.size;
    }
    return free;
  }

  class Mem {
    int index;
    int size;
    int[] mem;

    Mem(int index, int size, int[] mem) {
      this.index = index;
      this.size = size;
      this.mem = mem;
      Arrays.fill(mem, index, index + size, 1);
    }

    @Override
    public int hashCode() {
      return index;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Mem) {
        Mem other = (Mem) obj;
        return other.index == this.index && other.size == this.size;
      }
      return false;
    }

    int free() {
      Arrays.fill(mem, index, index + size, -1);
      return size;
    }
  }

}
