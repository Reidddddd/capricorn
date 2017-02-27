package leetcode.java.medium;

public class CourseSchedule_207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0) return true;

    int[] visited = new int[numCourses];
    int[] onStack = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, prerequisites, visited, onStack)) return false;
    }
    return true;
  }

  private boolean dfs(int i, int[][] prerequisites, int[] visited, int[] onStack) {
    if (visited[i] == 0) {
      visited[i] = 1;
      onStack[i] = 1;
      for (int j = 0; j < prerequisites.length; j++) {
        if (prerequisites[j][1] == i) {
          if (!dfs(prerequisites[j][0], prerequisites, visited, onStack)) return false;
        }
      }
      onStack[i] = 0;
    } else if (onStack[i] == 1) {
      return false;
    }
    return true;
  }
}
