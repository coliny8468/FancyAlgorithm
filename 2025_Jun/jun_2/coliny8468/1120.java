import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        int minCnt = Integer.MAX_VALUE;

        if (a.length() == b.length()) {
            System.out.println(makeAns(a, b));
        }else{
            for (int i = 0; i <= (b.length()-a.length()); i++) {
                minCnt = Math.min(makeMinCnt(i, a,b), minCnt);
            }

            System.out.println(minCnt);
        }
    }

    static int makeMinCnt(int x, String a, String b){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(b.charAt(i));
        }

        sb.append(a);

        for (int i =  b.length() -a.length() - x ; i > 0; i--) {
            sb.append(b.charAt(b.length() - i ));
        }
       return makeAns(sb.toString(), b);
    }

    static int makeAns(String a, String b){
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt ++;
            }
        }
        return cnt;
    }
}
