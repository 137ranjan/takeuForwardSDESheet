package org.example.recursion;

import java.util.ArrayList;

public class RatInAMaze {

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[mat.size()][mat.getFirst().size()];
        StringBuilder path = new StringBuilder();
        if (mat.getFirst().getFirst() == 1) {
            findPathUtil(0, 0, mat, result, visited, path);
        }
        return result;
    }

    private void findPathUtil(int i, int j, ArrayList<ArrayList<Integer>> mat, ArrayList<String> result, boolean[][] visited, StringBuilder path) {
        if (i == mat.size() - 1 && j == mat.getFirst().size() - 1) {
            result.add(path.toString());
            return;
        }

        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        String dir = "DLRU";

        for (int index = 0; index < 4; index++) {
            int nextI = i + di[index];
            int nextJ = j + dj[index];

            if (nextI >= 0 && nextJ >= 0 && nextI < mat.size() && nextJ < mat.getFirst().size()
                    && !visited[nextI][nextJ] && mat.get(nextI).get(nextJ) != 0) {
                visited[i][j] = true;
                findPathUtil(nextI, nextJ, mat, result, visited, path.append(dir.charAt(index)));
                path.deleteCharAt(path.length()-1);
                visited[i][j] = false;
            }
        }
    }
}
