import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (!stack.isEmpty()) {
                char p = stack.peek();
                if (ch == '-') {
                    if (p == 'c' || p == 'd') {
                        answer++;
                        stack.pop();
                        answer += stack.size();
                        stack.clear();
                    }
                } else if (ch == 'j') {
                    if (p == 'l' || p == 'n') {
                        answer++;
                        stack.pop();
                        answer += stack.size();
                        stack.clear();
                    } else {
                        stack.add(ch);
                    }
                } else if (ch == '=') {
                    if (p == 'c' || p == 's') {
                        answer++;
                        stack.pop();
                    } else if (p == 'z') {
                        answer++;
                        stack.pop();
                        if (!stack.isEmpty() && stack.peek() == 'd') {
                            stack.pop();
                        }
                        answer += stack.size();
                        stack.clear();
                    }
                } else {
                    stack.add(ch);
                }
            } else {
                stack.add(ch);
            }
        }

        System.out.println(answer + stack.size());
    }
}
