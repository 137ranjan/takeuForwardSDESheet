package org.example.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        while (!q.isEmpty()) {
            Point curr = q.remove();
            for (int[] direction : directions) {
                Point p = new Point(curr.x + direction[0], curr.y + direction[1], curr.t + 1);
                if (p.x >= 0 && p.x < r && p.y >= 0 && p.y < c && !visited[p.x][p.y] && grid[p.x][p.y] == 1) {
                    q.add(p);
                    visited[p.x][p.y] = true;
                    time = Math.max(time, p.t);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    static class Point {
        int x;
        int y;
        int t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
