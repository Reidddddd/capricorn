package leetcode.java.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII_210 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] order = new int[numCourses];
    for (int i = 0; i < numCourses; i++)
      order[i] = i;
    if (prerequisites.length == 0) return order;

    int[] visited = new int[numCourses];
    int[] onStack = new int[numCourses];
    HashMap<Integer, HashSet<Integer>> neigh = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      neigh.putIfAbsent(prerequisites[i][1], new HashSet<>());
      neigh.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    List<Integer> topo = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, prerequisites, visited, onStack, topo, neigh)) return new int[0];
    }

    for (int i = topo.size() - 1, k = 0; i >= 0; i--, k++) {
      order[k] = topo.get(i);
    }
    return order;
  }

  private boolean dfs(int i, int[][] prerequisites, int[] visited, int[] onStack,
      List<Integer> topo, HashMap<Integer, HashSet<Integer>> neigh) {
    if (visited[i] == 0) {
      visited[i] = 1;
      onStack[i] = 1;
      if (neigh.containsKey(i)) {
        for (int n : neigh.get(i)) {
          if (!dfs(n, prerequisites, visited, onStack, topo, neigh)) return false;
        }
      }
      topo.add(i);
      onStack[i] = 0;
    } else if (onStack[i] == 1) return false;
    return true;
  }
}
