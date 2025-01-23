mport java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long K = scanner.nextLong();
        scanner.close();

        System.out.println(getKthLuckyNumber(K));
    }

    public static String getKthLuckyNumber(long K) {
        StringBuilder result = new StringBuilder();

        while (K > 0) {
            // K를 2진수로 변환하듯이 4와 7을 매핑
            if (K % 2 == 1) {
                result.append("4");
            } else {
                result.append("7");
            }
            K = (K - 1) / 2;
        }

        // 결과를 뒤집어 올바른 순서로 반환
        return result.reverse().toString();
    }
}
