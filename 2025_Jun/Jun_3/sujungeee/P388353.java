import java.util.ArrayList;
import java.util.List;

class Solution388353 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[][] containers;
    int n, m;

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();

        // 1
        containers = new char[n][m];
        for (int i = 0; i < n; i++) {
            containers[i] = storage[i].toCharArray();
        }

        for (String request: requests) {
            char c = request.charAt(0);
            List<int[]> applys = new ArrayList<>();
            if (request.length() == 1) {
                // 2-1
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (containers[i][j] == c) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                applys.add(new int[]{i, j});
                                continue;
                            }
                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (containers[x][y] == '.') {
                                    applys.add(new int[]{i, j});
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int[] apply : applys) {
                    containers[apply[0]][apply[1]] = '.';
                }
            } else {
                // 2-2
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (containers[i][j] == c) {
                            boolean isAccess = false; // 외부로부터 접근이 가능한 좌표인지 여부
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                containers[i][j] = '.';
                                isAccess = true;
                            } else {
                                for (int k = 0; k < 4; k++) {
                                    int x = i + dx[k];
                                    int y = j + dy[k];
                                    if (containers[x][y] == '.') {
                                        containers[i][j] = '.';
                                        isAccess = true;
                                        break;
                                    }
                                }
                            }
                            if(!isAccess) {
                                containers[i][j] = ',';
                            }
                        }
                    }
                }
            }

            // 2-3
            boolean changed; // 외부 접근이 가능한 좌표로 인해 특정 좌표가 외부 접근 X -> 외부 접근 O 이 되었는지 여부
            do {
                changed = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (containers[i][j] == ',') {
                            for (int k = 0; k < 4; k++) {
                                int x = i + dx[k];
                                int y = j + dy[k];
                                if (x >= 0 && x < n && y >= 0 && y < m && containers[x][y] == '.') {
                                    containers[i][j] = '.';
                                    changed = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } while (changed);
        }

        // 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] != '.' && containers[i][j] != ',') {
                    answer++;
                }
            }
        }
        return answer;
    }
}

public class P388353 {
    public static void main(String[] args) {
        Solution388353 s = new Solution388353();

        System.out.println(s.solution(new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[] {"A", "BB", "A"}));
        System.out.println(s.solution(new String[] {"HAH", "HBH", "HHH", "HAH", "HBH"}, new String[] {"C", "B", "B", "B", "B", "H"}));
    }
    }