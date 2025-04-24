import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price25 =  sc.nextInt();
        int gram25 = sc.nextInt();
        float minPrice = (float) price25 /gram25;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, (float)sc.nextInt()/sc.nextInt());
        }

   float price1000 = minPrice * 1000;
float rounded = Math.round(price1000 * 100) / 100f; // 소수 셋째 자리에서 반올림
System.out.printf("%.2f\n", rounded);

    }
}
