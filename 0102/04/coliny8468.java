import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Long> decreasingNum = new ArrayList<>();

        for (int length = 1; length <= 10; length++) {
            makeDecreasingNum(0, length, 9, decreasingNum);
        }

        Collections.sort(decreasingNum);

        if (decreasingNum.size() >= N) {
            System.out.println(decreasingNum.get(N - 1));
        } else {
            System.out.println(-1);
        }
    }

    // 자리수가 주어지면 max 값보다 작아지는 수를 만들어 리스트에 저장하는 함수
    static void makeDecreasingNum(long current, int length, int max, ArrayList<Long> list) {
        if (length == 0) { // 모든 자리수를 채웠으므로 리턴
            list.add(current);
            return;
        }

        for (int i = max; i >= 0; i--) { // max보다 점점 작아지며 수를 하나씩 추가
            makeDecreasingNum(current * 10 + i, length - 1, i - 1, list);
        }
    }
}
