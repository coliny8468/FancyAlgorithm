import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        Arrays.sort(s);

        for (int num : s) {
            if (num == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 1001;

        for (int num : s) {
            if (num < n) left = num;
            else if (num > n && num < right) right = num;
        }

        int count = 0;
        for (int a = left + 1; a <= n; a++) {
            for (int b = n; b < right; b++) {
                if (a < b) count++;
            }
        }

        System.out.println(count);
    }
}
