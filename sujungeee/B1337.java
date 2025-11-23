import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        int answer = 4;

        for (int i = 0; i < N; i++) {
            int start= nums[i];
            int cnt = 1;

            for (int j = i + 1; j < N; j++) {
                if (nums[j] <= start + 4) {
                    cnt++;
                } else {
                    break;
                }
            }

            int needNum = 5 - cnt;
            answer = Math.min(answer, needNum);
            if (answer == 0) break;
        }

        System.out.println(answer);
    }
}