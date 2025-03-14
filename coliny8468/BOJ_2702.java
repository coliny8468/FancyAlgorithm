import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int maxDiv = 0;

            for (int j = 1; j <= Math.min(x,y); j++) {
                if (x%j == 0 && y%j ==0) {
                    maxDiv = j;
                }
            }
            System.out.println(x/maxDiv * y +" " + maxDiv);
        }


    }
}
