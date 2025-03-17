import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        boolean success = true;
        Stack<Character> stack = new Stack<>();
        while (true) {
            str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            stack.clear();
            success = true;
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.add(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        success = false;
                        break;
                    }
                }

                if (ch == '[') {
                    stack.add(ch);
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        success = false;
                        break;
                    }
                }
            }

            if (success && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
