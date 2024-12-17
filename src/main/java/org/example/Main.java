package org.example;

import org.example.stackqueue.RottenOranges;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {0,0,1},
                {1,1,1}
        };
        RottenOranges solution = new RottenOranges();
        System.out.println(solution.orangesRotting(grid));
    }
}