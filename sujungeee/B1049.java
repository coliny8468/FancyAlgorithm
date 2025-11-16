import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long answer;

    public static void main(String[] args) throws IOException {
        answer = Long.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int minPPrice = 1001;
        int minSPrice = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pPrice = Integer.parseInt(st.nextToken());
            int sPrice = Integer.parseInt(st.nextToken());

            minPPrice = Math.min(minPPrice, pPrice);
            minSPrice = Math.min(minSPrice, sPrice);
        }

        long pCount = (N + 5) / 6;
        long price1 = pCount * minPPrice;
        answer = Math.min(answer, price1);

        long price2 = (long) N * minSPrice;
        answer = Math.min(answer, price2);

        long remaining = N % 6;
        long price3 = ((long) N / 6) * minPPrice + remaining * minSPrice;
        answer = Math.min(answer, price3);

        System.out.println(answer);
    }
}