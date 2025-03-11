import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        boolean isSuccess;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            stack.clear();
            isSuccess = true;
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.add(ch);
                } else {
                    if (stack.isEmpty()) {
                        isSuccess = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (isSuccess && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
