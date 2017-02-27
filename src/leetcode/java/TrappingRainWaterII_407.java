package leetcode.java.hard;

import java.util.PriorityQueue;

public class TrappingRainWaterII_407 {
  private int water;
  private boolean[][] visited;

  public int trapRainWater(int[][] heightMap) {
    if (heightMap.length == 0) return 0;
    int row = heightMap.length;
    int col = heightMap[0].length;
    water = 0;
    PriorityQueue<Cell> walls = new PriorityQueue<>();
    visited = new boolean[row][col];
    for (int i = 0; i < col; i++) {
      walls.offer(new Cell(0, i, heightMap[0][i]));
      visited[0][i] = true;
      walls.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
      visited[row - 1][i] = true;
    }
    for (int i = 1; i < row - 1; i++) {
      walls.offer(new Cell(i, 0, heightMap[i][0]));
      visited[i][0] = true;
      walls.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
      visited[i][col - 1] = true;
    }
    while (!walls.isEmpty()) {
      Cell min = walls.poll();
      visit(heightMap, min, walls);
    }
    return water;
  }

  private void visit(int[][] heightMap, Cell min, PriorityQueue<Cell> walls) {
    fill(heightMap, min.x + 1, min.y, min.h, walls);
    fill(heightMap, min.x - 1, min.y, min.h, walls);
    fill(heightMap, min.x, min.y + 1, min.h, walls);
    fill(heightMap, min.x, min.y - 1, min.h, walls);
  }

  private void fill(int[][] heightMap, int x, int y, int h, PriorityQueue<Cell> walls) {
    if (x < 0 || y < 0 || x >= heightMap.length || y >= heightMap[0].length || visited[x][y]) return;
    else if (heightMap[x][y] >= h) {
      walls.offer(new Cell(x, y, heightMap[x][y]));
      visited[x][y] = true;
      return;
    } else {
      water += h - heightMap[x][y];
      visited[x][y] = true;
      fill(heightMap, x + 1, y, h, walls);
      fill(heightMap, x - 1, y, h, walls);
      fill(heightMap, x, y + 1, h, walls);
      fill(heightMap, x, y - 1, h, walls);
    }
  }

  class Cell implements Comparable<Cell> {
    int x, y, h;
    Cell(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }
    @Override
    public int compareTo(Cell o) {
      return h - o.h;
    }
  }
}
