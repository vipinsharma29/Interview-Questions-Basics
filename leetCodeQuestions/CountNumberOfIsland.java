package leetCodeQuestions;

public class CountNumberOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 0, 0},
        };

        System.out.println(numIslands(grid));
    }

    private static int numIslands(int[][] grid) {
        int count = 0, rowLength = grid.length, columnLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, rowLength, columnLength);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] grid, int i, int j, int rowLength, int columnLength) {

        if (i < 0 || j < 0 || i >= rowLength || j >= columnLength || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j, rowLength, columnLength); // down
        dfs(grid, i - 1, j, rowLength, columnLength); // up
        dfs(grid, i, j + 1, rowLength, columnLength); // right
        dfs(grid, i, j - 1, rowLength, columnLength); // left
    }
}
