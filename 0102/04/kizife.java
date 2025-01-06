import java.util.*;

public class BOJ_1174 {

    static List<Long> decreasingNums = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //모든 감소하는 수 생성
        for (int len = 1; len <= 10; len++) {
            decreasingNum(0, len, 9);
        }

        //수를 정렬
        Collections.sort(decreasingNums);

        //n번째 감소하는 수 출력
        //존재하지 않으면 -1 출력
        if (n > decreasingNums.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decreasingNums.get(n - 1));
        }
    }

    //재귀적으로 감소하는 수를 생성
    static void decreasingNum(long now, int length, int maxDigit) {
        if (length == 0) {
            decreasingNums.add(now);
            return;
        }

        for (int digit = maxDigit; digit >= 0; digit--) {
            decreasingNum(now * 10 + digit, length - 1, digit - 1);
        }
    }
}
