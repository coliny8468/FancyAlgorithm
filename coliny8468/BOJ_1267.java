import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int minsick = 0;
        int youngsick = 0;

        for (int i = 0; i < n; i++) {
            int min = sc.nextInt();
            minsick = minsick + min/30 * 10+ 10;
            youngsick = youngsick + min/60 *15 + 15;
        }

        if (minsick <youngsick) {
            System.out.println("Y " + minsick);
        } else if (youngsick< minsick) {
            System.out.println("M " + youngsick);
        }else{
            System.out.println("Y M " + minsick);
        }

    }
}
