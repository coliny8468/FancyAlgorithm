import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            } else if (str.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(stack.pop());
                }
                sb.append("\n");
            } else if (str.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (str.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            } else if (str.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(stack.peek());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
