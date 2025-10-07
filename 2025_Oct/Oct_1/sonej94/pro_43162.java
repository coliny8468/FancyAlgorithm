class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited, n);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int cur, int[][] g, boolean[] visited, int n) {
        
        visited[cur] = true;
        for (int next = 0; next < n; next++) {
            if (g[cur][next] == 1 && !visited[next]) {
                dfs(next, g, visited, n);
            }
        }
    }
}
