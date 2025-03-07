import java.util.Scanner;

import static java.lang.System.exit;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int nanugi = sc.nextInt();

   
            int m = n - n%100;
            for (int i = 0; i < 100; i++) {
                if ((m + i)%nanugi == 0 ) {
                    if (i < 10) {
                        System.out.println("0" + i);
                        return;
                    }else {
                        System.out.println(i);
                        return;
                    }

                }
            }
        


    }
}
