import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int c = 0; c < cols; c++) {
            pacific[0][c] = true;
            pacificQueue.add(new int[]{0, c});

            atlantic[rows - 1][c] = true;
            atlanticQueue.add(new int[]{rows - 1, c});
        }
        for (int r = 0; r < rows; r++) {
            pacific[r][0] = true;
            pacificQueue.add(new int[]{r, 0});

            atlantic[r][cols - 1] = true;
            atlanticQueue.add(new int[]{r, cols - 1});
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

       
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};   // down, up, right, left

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < dirs.length; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;   // out of grid
                if (visited[nr][nc]) continue;                                // already reached
                if (heights[nr][nc] < heights[r][c]) continue;                // lower, water can't climb

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}
