// https://www.acmicpc.net/problem/16974
// 16974: 레벨 햄버거
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sujungeee {
    public static long answer;
    public static int N;
    public static long X;
    public static long[] patties;
    public static long[] total;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        X= Long.parseLong(st.nextToken());

        patties= new long[N+1];
        total= new long[N+1];

        patties[0]= 1L;
        total[0]= 1L;

        for(int i=1; i<=N; i++) {
            patties[i]= 1 + 2 * patties[i-1];
            total[i]= 3 + 2 * total[i-1];
        }

        answer= recur(X, N);
        System.out.println(answer);
    }

    public static long recur(long x, int lv) { // lv: 레벨, x: 햄버거 레이어 수
        if (lv == 0) return x == 1 ? 1 : 0;

        long mid = total[lv - 1] + 2;

        if (x == 1) {
            return 0;
        } else if (x == total[lv]) {
            return patties[lv];
        } else if (x == mid) {
            return patties[lv - 1] + 1;
        } else if (x < mid) {
            return recur(x - 1, lv - 1);
        } else if (x > mid) {
            return patties[lv - 1] + 1 + recur(x - mid, lv - 1);
        }
        return -1;
    }
}