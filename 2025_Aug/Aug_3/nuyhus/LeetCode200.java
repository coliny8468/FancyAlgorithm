class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        
        int x = grid.length;
        int y = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, x, y, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void bfs(char[][] grid, int r, int c, int x, int y) {

        grid[x][y] = '0';
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            
            int[] cxy = q.remove();
            int cx = cxy[0];
            int cy = cxy[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
    }
}
