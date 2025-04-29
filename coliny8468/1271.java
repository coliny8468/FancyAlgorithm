import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = new BigInteger(sc.next()); //이런게 있는지 처음알았네  n과 m이 최대 10의 1000제곱까지 커질 수 있는 초대형 정수이기 때문에, 일반적인 정수 자료형(int, long, float, double)로는 절대 처리할 수 없습니다.
        BigInteger m = new BigInteger(sc.next()); 

        System.out.println(n.divide(m)); 
        System.out.println(n.remainder(m)); 
    }
}
