
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();


        int minA = 0;
        int minB = 0;
        int maxA = 0;
        int maxB = 0;

        for (int i = a.length()-1; i >= 0; i--) {
            int now = Integer.parseInt(String.valueOf(a.charAt(i)));
            if (now == 5) {
                minA = minA + (int) (5 * Math.pow(10,(a.length()-1)-i));
                maxA = maxA + (int) (6 * Math.pow(10,(a.length()-1)-i));
            } else if (now == 6) {
                minA = minA + (int) (5 * Math.pow(10,(a.length()-1)-i));
                maxA = maxA + (int) (6 * Math.pow(10,(a.length()-1)-i));
            }else {
                minA = minA + (int) (now * Math.pow(10,(a.length()-1)-i));
                maxA = maxA + (int) (now * Math.pow(10,(a.length()-1)-i));
            }
        }

        for (int i = b.length()-1; i >= 0; i--) {
            int now = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (now == 5){
                minB = minB + (int) (5 * Math.pow(10,(b.length()-1)-i));
                maxB = maxB +(int) (6 * Math.pow(10,(b.length()-1)-i));
            } else if (now == 6){
                minB = minB + (int) (5 * Math.pow(10,(b.length()-1)-i));
                maxB = maxB +(int) (6 * Math.pow(10,(b.length()-1)-i));
            }else {
                minB = minB + (int) (now * Math.pow(10,(b.length()-1)-i));
                maxB = maxB +(int) (now * Math.pow(10,(b.length()-1)-i));
            }
        }

        System.out.print(minA+minB+" ");
        System.out.print(maxA +maxB);
    }
}
