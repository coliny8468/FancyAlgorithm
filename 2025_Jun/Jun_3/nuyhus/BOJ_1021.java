import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int totalSize, size;
    static int[] location;
    static Queue<Integer> q = new ArrayDeque<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        totalSize = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        location = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= totalSize; i++) {
            q.add(i);
        }

        for (int target = 0; target < size; target++) {
            Queue<Integer> tempLeftQ = new ArrayDeque<>();
            Stack<Integer> stack = new Stack<>();
            int tempSize = q.size();
            for (int i = 0; i < tempSize; i++) {
                int temp = q.remove();
                tempLeftQ.add(temp);
                stack.add(temp);
            }
            int two = 0;
            int left = tempLeftQ.remove();
            while (left != location[target]) {
                tempLeftQ.add(left);
                left = tempLeftQ.remove();
                two++;
            }
            int three = 1;
            int right = stack.pop();
            while (right != location[target]) {
                stack.add(0, right);
                right = stack.pop();
                three++;
            }
            if (two < three) {
                answer += two;
                int leftSize = tempLeftQ.size();
                for (int i = 0; i < leftSize; i++) {
                    int temp = tempLeftQ.remove();
                    q.add(temp);
                }
            } else {
                answer += three;
                for (int i = 0; i < stack.size(); i++) {
                    int temp = stack.elementAt(i);
                    q.add(temp);
                }
            }
        }

        System.out.println(answer);
    }
}
