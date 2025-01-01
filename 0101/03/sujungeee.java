// https://www.acmicpc.net/problem/6198
// 6198: 옥상 정원 꾸미기

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class sujungeee {
    public static int N;
    public static long answer;

    public static void main(String[] args) throws IOException {
        answer= 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack= new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            int tmp= Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peekLast() <= tmp) {
                stack.pollLast();
            }
            stack.addLast(tmp);
            answer+= stack.size() - 1;
        }

        System.out.println(answer);
    }
}