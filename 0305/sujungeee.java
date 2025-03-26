// https://www.acmicpc.net/problem/1374
// 1374: 강의실
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sujungeee {
    public static int N;
    public static PriorityQueue<int []> times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[2];
            st.nextToken();
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            times.add(tmp);
        }

        solution();
    }

    public static void solution() {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        while(!times.isEmpty()) {
            int[] info = times.poll();
            int startTime = info[0];
            int endTime = info[1];

            if (!rooms.isEmpty() && rooms.peek() <= startTime) {
                rooms.poll();
            }

            rooms.add(endTime);
        }
        System.out.println(rooms.size());
    }
}