import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }

            result += stack.size();

            stack.push(heights[i]);
        }

        System.out.println(result);
    }
}
