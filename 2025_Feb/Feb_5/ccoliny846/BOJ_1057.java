import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int jimin = sc.nextInt();
         int hansu = sc.nextInt();

         int round = 0;

         while (true){
             round++;
             int max  = Math.max(jimin, hansu);
             if (Math.abs(jimin-hansu) == 1 && max%2 == 0) {
                 System.out.println(round);
                 return;
             }

             if (jimin%2 == 0 ) {
                 jimin = jimin/2;
             }else{
                 jimin = jimin/2 + 1;
             }

             if (hansu%2 == 0 ) {
                 hansu = hansu/2;
             }else{
                 hansu = hansu/2 + 1;
             }

         }

    }
}
