import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            max = Math.max(max, score);

            scores[i] = score;
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            int ori = scores[i];
            double newScore = (double) ori /max*100;

            sum += newScore;
        }

        System.out.println(sum/n);
    }


}
