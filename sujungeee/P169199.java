// https://school.programmers.co.kr/learn/courses/30/lessons/169199

import java.util.ArrayDeque;

/**
 * 169199: 리코쳇 로봇
 * # summary
 * : 로봇이 장애물을 피해 목적지까지 가야하는 최소 횟수 구하기
 * # access
 * 1. 로봇이 갈 수 있는 방향으로 장애물 or 가장자리까지 좌표를 쭉 이동한다.
 * 2. 한 텀에 갈 수 있는 경우의 수를 모두 생각하기 때문에 가장 먼저 목적지에 도착한 경우의 수의 횟수를 return
 * => BFS 문제!
 *    다만, 이동할 때 전의 위치로 되돌아가면 안되므로 자신이 어디서부터 왔는지 방향도 함께 저장해주어야 한다.
 * # logic
 * 1. 로봇의 위치를 먼저 찾기
 * 2. search(): 최소 횟수로 목적지에 가는 경우의 수를 찾는 함수
 *     2-1. 첫 로봇 위치 정보를 queue에 add
 *     2-2. 로봇의 위치 정보를 queue에서 꺼내어 목적지에 도달하면 이동 횟수(cnt) return
 *     2-3. 목적지가 아니라면 갈 수 있는 방향을 찾는다.
 *     2-4. 갈 수 있는 방향으로 장애물 or 가장자리까지 좌표를 이동한다.
 *     2-5. 새 좌표를 방문하지 않았다면 queue에 add
 */

class Solution169199 {
    class Coord {
        int x, y;
        int dir; // 동:0, 서: 1, 남: 2, 북: 3 (dx, dy의 방향)
        int cnt; // 이동 횟수

        Coord(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int N, M;
    int startX, startY; // 로봇 초기 좌표
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();

        // 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 2
        return search(board);
    }

    int search(String[] board) {
        ArrayDeque<Coord> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.addLast(new Coord(startX, startY, -1, 0));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            // 2-1
            Coord c = queue.pollFirst();

            // 2-2
            if (board[c.x].charAt(c.y) == 'G') return c.cnt;

            // 2-3
            int[] dirs;
            if (c.dir == -1)  dirs = new int[] {0, 1, 2, 3};
            else if (c.dir == 0 || c.dir == 1) dirs = new int[] {2, 3};
            else if (c.dir == 2 || c.dir == 3) dirs = new int[] {0, 1};
            else dirs= new int[0];

            // 2-4
            for (int dir : dirs) {
                int newX = -1;
                int newY = -1;
                int tmpX = c.x;
                int tmpY = c.y;
                while (true) {
                    tmpX += dx[dir];
                    tmpY += dy[dir];
                    if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || board[tmpX].charAt(tmpY) == 'D') {
                        break;
                    } else {
                        newX = tmpX;
                        newY = tmpY;
                    }
                }

                // 2-5
                if (newX != -1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.addLast(new Coord(newX, newY, dir, c.cnt + 1));
                }
            }
        }

        return -1;
    }
}

public class P169199 {
    public static void main(String[] args) {
        Solution169199 s = new Solution169199();

        System.out.println(s.solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(s.solution(new String[] {".D.R", "....", ".G..", "...D"}));
    }
}