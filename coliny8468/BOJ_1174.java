import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // 줄어드는 수를 저장할 리스트
        ArrayList<Long> decreasingNumbers = new ArrayList<>();

        // 0부터 9까지 숫자를 사용하여 줄어드는 수 생성
        for (int length = 1; length <= 10; length++) {
            generateDecreasingNumbers(0, length, 9, decreasingNumbers);
        }

        // 정렬
        Collections.sort(decreasingNumbers);

        // 결과 출력
        if (N > decreasingNumbers.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decreasingNumbers.get(N - 1));
        }
    }

    // 줄어드는 수를 재귀적으로 생성하는 함수
    private static void generateDecreasingNumbers(long current, int length, int maxDigit, ArrayList<Long> list) {
        if (length == 0) {
            list.add(current);
            return;
        }

        // 현재 숫자에 추가할 다음 자릿수는 maxDigit 이하로 제한
        for (int digit = maxDigit; digit >= 0; digit--) {
            generateDecreasingNumbers(current * 10 + digit, length - 1, digit - 1, list);
        }
    }
}
