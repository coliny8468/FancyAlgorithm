import java.util.*;
import java.io.*;

public class nuyhus {

    static class Node {
        int isFirst;
        int targetPlayer;

        Node(int isFirst, int targetPlayer) {
            this.isFirst = isFirst;
            this.targetPlayer = targetPlayer;
        }
    }

    static int[][] first = new int[10][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int isFirst = Integer.parseInt(st.nextToken());
            int targetPlayer = Integer.parseInt(st.nextToken());

            list.add(new Node(isFirst, targetPlayer));
            first[targetPlayer][isFirst]++;
        }

        int answerCnt = 0;
        int answer = -1;
        for (Node node : list) {
            first[node.targetPlayer][node.isFirst]--;
            first[node.targetPlayer][(node.isFirst + 1) % 2]++;

            List<Integer> firstPlayers = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                if (first[i][1] > 0) {
                    firstPlayers.add(i);
                }
            }

            if (firstPlayers.size() == 1) {
                int a = firstPlayers.get(0);
                if (first[a][0] == 0) {
                    answer = a;
                    answerCnt++;
                }
            }

            if (firstPlayers.isEmpty()) {
                List<Integer> firstPlayers2 = new ArrayList<>();
                for (int i = 1; i <= 9; i++) {
                    if (first[i][0] == 0) {
                        firstPlayers2.add(i);
                    }
                }

                if (firstPlayers2.size() == 1) {
                    answer = firstPlayers2.get(0);
                    answerCnt++;
                } else if (firstPlayers2.size() > 1) {
                    answer = -1;
                    break;
                }
            }

            if (answerCnt > 1) {
                answer = -1;
                break;
            }

            first[node.targetPlayer][node.isFirst]++;
            first[node.targetPlayer][(node.isFirst + 1) % 2]--;
        }

        System.out.println(answer);
    }
}