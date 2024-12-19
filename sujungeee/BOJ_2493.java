// https://www.acmicpc.net/problem/2493
// 2493: 탑
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2493 {
    static int N;
    static int[] tops;
    static int[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        tops= new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tops[i]= Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack= new ArrayDeque<>();
        answers= new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && tops[stack.peekLast()] < tops[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                answers[i] = stack.peekLast() + 1;
            }
            stack.addLast(i);
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }
}