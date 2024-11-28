package solutions.pack11_Graph;

import java.util.HashSet;
import java.util.Set;

public class TheLake {
    public int findTotalMaxDepth(int[][] input) {
        int totalMaxDepth = 0;
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                String pos = i + "," + j;
                if (!visited.contains(pos) || input[i][j] == 0) {
                    int max_depth = exploreLake(input, i, j, visited);
                    if (max_depth > totalMaxDepth) totalMaxDepth = max_depth;
                }
            }
        }
        return totalMaxDepth;
    }

    private int exploreLake(int[][] grid, int i, int j, Set<String> visited) {
        boolean rowBoundary = 0 <= j && j < grid[0].length;
        boolean colBoundary = 0 <= i && i < grid.length;
        if (!(rowBoundary && colBoundary)) return 0;

        String pos = i + "," + j;
        if (visited.contains(pos) || grid[i][j] == 0) return 0;

        visited.add(pos);

        return grid[i][j] +
                exploreLake(grid, i - 1, j, visited) +
                exploreLake(grid, i + 1, j, visited) +
                exploreLake(grid, i, j - 1, visited) +
                exploreLake(grid, i, j + 1, visited);
    }

}
