class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {   // new island found
                    count++;
                    dfs(grid, r, c);       // sink the whole island
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        // stop if out of bounds, water, or already visited
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';                  // mark visited

        dfs(grid, r + 1, c);               // down
        dfs(grid, r - 1, c);               // up
        dfs(grid, r, c + 1);               // right
        dfs(grid, r, c - 1);               // left
    }
}
