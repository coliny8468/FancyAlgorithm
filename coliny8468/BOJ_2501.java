import java.util.Scanner;

import static java.lang.System.exit;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int now = 0;
        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                now++;
                if (now == k) {
                    System.out.println(i);
                    return;
                }
            }
        }

        if (now < k){
            System.out.println(0);
        }



    }
}
