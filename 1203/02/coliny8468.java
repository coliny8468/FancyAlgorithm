import java.io.*;
import java.util.*;

public class Main {
    static class Top {
        int index, height;
        Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 첫 번째 줄: 탑의 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 두 번째 줄: 각 탑의 높이
        Stack<Top> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 스택의 탑과 비교, 현재 높이보다 낮은 탑을 제거
            while (!stack.isEmpty() && stack.peek().height < h) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // 스택이 비어있으면 출력 0
                sb.append("0 ");
            } else {
                // 스택의 가장 위에 있는 탑의 index 출력
                sb.append(stack.peek().index).append(" ");
            }

            // 현재 탑을 스택에 추가
            stack.add(new Top(i, h));
        }

        // 최종 출력
        System.out.println(sb);
    }
}
