import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        while (!s.equals(".")) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.add(s.charAt(i));
                } else{
                    if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else if (s.charAt(i) == ')') {
                        stack.add(s.charAt(i));
                    }

                    if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else if (s.charAt(i) == ']'){
                        stack.add(s.charAt(i));
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }

            s = sc.nextLine();
        }

    }
}
