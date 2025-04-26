import java.util.*;

public class Main {
    static int eningN;
    static int [][]score;
    static int maxScore;
    static Set<String> tajaOrder = new HashSet<>();
    static boolean[] visited = new boolean[9];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        eningN = sc.nextInt();
        score = new int[eningN][9];
        maxScore = 0;

        for (int i = 0; i < eningN; i++) {
            for (int j = 0; j < 9; j++) {
                score[i][j] = sc.nextInt();
            }
        }
        makeTajaOrder(0, "");
        calScore();
        System.out.println(maxScore);

    }

    //점수를 계산해서 최고점을 갱신해보자
    static void calScore() {
        for (String order : tajaOrder) {
            int points = 0;
            int inning = 0;
            int playerIndex = 0;

            int[] playOrder = new int[9];
            for (int i = 0; i < 9; i++) {
                playOrder[i] = order.charAt(i) - '0';
            }

            while (inning < eningN) {
                int outCnt = 0;
                boolean[] base = new boolean[4];
                while (outCnt < 3) {
                    int player = playOrder[playerIndex];
                    int result = score[inning][player];

                    switch (result) {
                        case 0:
                            outCnt++;
                            break;
                        case 1:
                            if (base[2]) { points++; base[2] = false; }
                            if (base[1]) { base[2] = true; base[1] = false; }
                            if (base[0]) { base[1] = true; base[0] = false; }
                            base[0] = true;
                            break;
                        case 2:
                            if (base[2]) { points++; base[2] = false; }
                            if (base[1]) { points++; base[1] = false; }
                            if (base[0]) { base[2] = true; base[0] = false; }
                            base[1] = true;
                            break;
                        case 3:
                            for (int i = 0; i < 3; i++) {
                                if (base[i]) { points++; base[i] = false; }
                            }
                            base[2] = true;
                            break;
                        case 4:
                            for (int i = 0; i < 3; i++) {
                                if (base[i]) { points++; base[i] = false; }
                            }
                            points++;
                            break;
                    }

                    playerIndex = (playerIndex + 1) % 9;
                }
                inning++;
            }

            maxScore = Math.max(points, maxScore);
        }
    }


// 4번재 타자가 0인 순열 만들기...
    static void makeTajaOrder(int depth, String nowOrder){
        if (depth == 9) {
            tajaOrder.add(nowOrder);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            if (depth == 3 && i != 0) continue;
            if (depth != 3 && i == 0) continue;

            visited[i] = true;
            makeTajaOrder(depth + 1, nowOrder + i);
            visited[i] = false;
        }
    }
}
