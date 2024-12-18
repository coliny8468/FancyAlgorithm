import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BOJ_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] tops = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && tops[stack.peek()] < tops[i]) {
                //스택에 저장된 최상단 인덱스.의 탑.보다! 현재 탑이 높다면!
                stack.pop(); // 그 최상단 인덱스를 스택에서 제거함
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek() + 1;
            } else {
                answer[i] = 0;
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
