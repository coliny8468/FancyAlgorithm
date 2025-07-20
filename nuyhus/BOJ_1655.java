import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (maxPq.size() == minPq.size()) {
                maxPq.add(temp);

                if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            } else {
                minPq.add(temp);

                if (maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }
            System.out.println(maxPq.peek());
        }
    }
}
