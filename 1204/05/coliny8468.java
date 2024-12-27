import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[10][2]; // 0: not_pos, 1: pos

        // 입력 받기
        for (int i = 0; i < 9; i++) {
            int booleanVal = sc.nextInt();
            int playerNum = sc.nextInt();
            board[playerNum][booleanVal]++;
        }

        Set<Integer> candSet = new HashSet<>();

        // 각 선수에 대해 거짓말 여부를 검사
        for (int candIdx = 1; candIdx <= 9; candIdx++) {
            int notPos = board[candIdx][0];
            int pos = board[candIdx][1];

            // 거짓말을 "0"으로 할 경우
            if (notPos == 1) {
                board[candIdx][0] = 0;
                board[candIdx][1] = pos + 1;

                Set<Integer> result = getCandidates(board);
                if (result != null) {
                    candSet.addAll(result);
                }

                // 원래 상태로 복원
                board[candIdx][0] = notPos;
                board[candIdx][1] = pos;
            }

            // 거짓말을 "1"으로 할 경우
            if (pos == 1) {
                board[candIdx][0] = notPos + 1;
                board[candIdx][1] = 0;

                Set<Integer> result = getCandidates(board);
                if (result != null) {
                    candSet.addAll(result);
                }

                // 원래 상태로 복원
                board[candIdx][0] = notPos;
                board[candIdx][1] = pos;
            }
        }

        // 결과 출력
        if (candSet.size() == 1) {
            System.out.println(candSet.iterator().next());
        } else {
            System.out.println(-1);
        }
    }

    private static Set<Integer> getCandidates(int[][] board) {
        Set<Integer> notPosSet = new HashSet<>();
        Set<Integer> posSet = new HashSet<>();

        for (int idx = 1; idx <= 9; idx++) {
            int notPos = board[idx][0];
            int pos = board[idx][1];

            // 모순 발생
            if (notPos > 0 && pos > 0) {
                return null;
            }

            // X만 있는 경우
            if (notPos > 0 && pos == 0) {
                notPosSet.add(idx);
            }

            // O만 있는 경우
            if (pos > 0 && notPos == 0) {
                posSet.add(idx);
            }
        }

        // 가능한 후보가 1개인 경우
        if (posSet.size() == 1) {
            return posSet;
        }

        // 모든 가능성에서 제외된 선수를 제거한 후보 반환
        if (posSet.isEmpty()) {
            Set<Integer> allPlayers = new HashSet<>();
            for (int i = 1; i <= 9; i++) {
                allPlayers.add(i);
            }
            allPlayers.removeAll(notPosSet);
            return allPlayers;
        }

        return null;
    }
}
