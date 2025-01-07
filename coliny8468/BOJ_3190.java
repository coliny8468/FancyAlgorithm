import java.util.*;

public class Main {
    // 방향 정의: 위(0), 오른쪽(1), 아래(2), 왼쪽(3)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 보드 크기 N, 사과의 개수 K 입력
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // 사과의 위치 입력
        boolean[][] board = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt() - 1;  // 1-based -> 0-based
            int y = sc.nextInt() - 1;  // 1-based -> 0-based
            board[x][y] = true;  // 사과가 있는 곳은 true
        }
        
        // 방향 전환 횟수 L 입력
        int L = sc.nextInt();
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            turns.put(X, C);  // X초 후에 C 방향 전환
        }
        
        // 게임 시뮬레이션 시작
        System.out.println(runGame(N, board, turns));
    }

    private static int runGame(int N, boolean[][] board, Map<Integer, Character> turns) {
        // 뱀의 초기 상태
        Deque<int[]> snake = new LinkedList<>();
        Set<String> snakeSet = new HashSet<>();
        
        snake.addFirst(new int[]{0, 0});  // 뱀의 초기 위치 (0, 0)
        snakeSet.add("0,0");
        
        int direction = 1;  // 초기 방향은 오른쪽 (1)
        int time = 0;  // 게임 시간
        int turnIndex = 1;  // 방향 전환 시간 index
        
        while (true) {
            time++;  // 매 초마다 시간이 흐름
            
            // 현재 뱀 머리 위치 계산
            int[] head = snake.peekFirst();
            int x = head[0] + dx[direction];
            int y = head[1] + dy[direction];
            
            // 벽에 부딪히거나 자기자신의 몸에 부딪히면 게임 종료
            if (x < 0 || y < 0 || x >= N || y >= N || snakeSet.contains(x + "," + y)) {
                return time;  // 종료 시간 반환
            }
            
            // 새로운 머리 추가
            snake.addFirst(new int[]{x, y});
            snakeSet.add(x + "," + y);
            
            // 사과가 있다면 꼬리 그대로 두고, 없으면 꼬리 제거
            if (!board[x][y]) {
                int[] tail = snake.pollLast();
                snakeSet.remove(tail[0] + "," + tail[1]);
            } else {
                board[x][y] = false;  // 사과는 먹었으므로 없애기
            }
            
            // 방향 전환 처리
            if (turns.containsKey(time)) {
                char turnDirection = turns.get(time);
                if (turnDirection == 'L') {
                    direction = (direction + 3) % 4;  // 왼쪽 회전 (90도)
                } else if (turnDirection == 'D') {
                    direction = (direction + 1) % 4;  // 오른쪽 회전 (90도)
                }
            }
        }
    }
}
