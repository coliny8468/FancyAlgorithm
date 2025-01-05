import java.util.*;

public class Main {
    static String word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        word = sc.next();
        int n = word.length();
        boolean checkAllSame = true;

        for (int i = 0; i < n/2; i++) {
            if (word.charAt(i) != word.charAt(n-1-i)) {
                System.out.println(n);
                return;
            }

            if (word.charAt(i) != word.charAt(i+1)) {
                checkAllSame = false;
            }
        }

        if (checkAllSame) {
            System.out.println(-1);
        }else {
            System.out.println(n-1);

        }
    }
}
