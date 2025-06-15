import java.util.Scanner;

public class BOJ_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }

        System.out.println(count);
    }
}
