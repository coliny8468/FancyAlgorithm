import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int score;
        int number;

        public Problem(int score, int number) {
            this.score = score;
            this.number = number;
        }

        @Override
        public int compareTo(Problem other) {
            return Integer.compare(other.score, this.score);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Problem[] problems = new Problem[8];
        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());
            problems[i] = new Problem(score, i + 1);
        }

        Arrays.sort(problems);

        int total = 0;
        int[] selected = new int[5];

        for (int i = 0; i < 5; i++) {
            total += problems[i].score;
            selected[i] = problems[i].number;
        }

        Arrays.sort(selected);

        System.out.println(total);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(selected[i]);
            if (i < 4) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}