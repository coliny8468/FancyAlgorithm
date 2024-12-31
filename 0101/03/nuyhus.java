import java.io.*;
import java.util.*;

public class nuyhus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
                cnt += stack.size();
            }

            stack.push(h);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            cnt += stack.size();
        }

        System.out.println(cnt);
    }
}