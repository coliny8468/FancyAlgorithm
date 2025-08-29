import java.util.Scanner;

public class BOJ_1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int diff = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    diff++;
                }
            }
            min = Math.min(min, diff);
        }

        System.out.println(min);
    }
}
