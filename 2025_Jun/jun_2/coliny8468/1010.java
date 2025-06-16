import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < n; i++) {
            int west = sc.nextInt();
            int east = sc.nextInt();
            System.out.println(combination(east, west));
        }
    }

    static BigInteger factorial(int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    static BigInteger combination(int n, int r) {
        if (r > n) return BigInteger.ZERO;

        // C(n, r) = n! / (r! * (n - r)!)
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
}
