// https://www.acmicpc.net/problem/13975
// 13975: 파일 합치기 3
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sujungeee {
    public static long answer;
    public static int T, K;
    public static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            pq= new PriorityQueue<>();
            K= Integer.parseInt(br.readLine());
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int idx = 0; idx < K; idx++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            solution();
            System.out.println(answer);
        }
    }

    public static void solution() {
        answer= 0;
        while(!pq.isEmpty()) {
            long n1= pq.poll();
            long n2= pq.poll();
            if (!pq.isEmpty()) {
                pq.add(n1+n2);
            }
            answer+= n1+n2;
        }
    }
}