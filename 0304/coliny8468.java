
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 비용이 작은 순으로 정렬
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int roomN = sc.nextInt();
            int road = sc.nextInt();
            List<Node>[] map = new ArrayList[roomN + 1];

            for (int j = 1; j <= roomN; j++) {
                map[j] = new ArrayList<>();
            }

            for (int j = 0; j < road; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                map[a].add(new Node(b, c));
                map[b].add(new Node(a, c));
            }

            int k = sc.nextInt();
            int start[] = new int[k];//사람이 있는 방을 저장할꺼
            int minDis[][] = new int[k][roomN + 1];//사람이 있는 방에서의 최소거리

            for (int j = 0; j < k; j++) {
                start[j] = sc.nextInt();
            }

            for (int j = 0; j < k; j++) {

                int startRoomN = start[j];

                for (int l = 1; l <= roomN; l++) {
                    minDis[j][l] = Integer.MAX_VALUE;
                }

                minDis[j][startRoomN] = 0;

                PriorityQueue<Node> pQ = new PriorityQueue<>();
                pQ.add(new Node(startRoomN, 0));

                while (!pQ.isEmpty()) {
                    Node now = pQ.poll();
                    int nowIndex = now.index;
                    int nowCost = now.cost;

                    if (nowCost > minDis[j][nowIndex]) continue;
                    if (map[nowIndex] != null) {
                        for (Node next : map[nowIndex]) {
                            int newCost = minDis[j][nowIndex] + next.cost;
                            if (newCost < minDis[j][next.index]) {
                                minDis[j][next.index] = newCost;
                                pQ.add(new Node(next.index, newCost));
                            }

                        }
                    }

                    {

                    }
                }

            }

            int min = Integer.MAX_VALUE;
            int ans = 0;

            for (int j = 1; j <= roomN; j++) {
                int sum = 0;
                for (int l = 0; l < k; l++) {
                    sum = sum + minDis[l][j];
                }

                if (sum < min) {
                    min = sum;
                    ans = j;
                }
            }

            System.out.println(ans);


        }


    }
}
