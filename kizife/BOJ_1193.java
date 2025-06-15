import java.util.Scanner;

public class BOJ_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 몇 번째 대각선에 있는지
        int line = 1;
        int sum = 0; // 지금까지의 분수 개수

        while (sum + line < n) {
            sum += line;
            line++;
        }

        // 해당 대각선에서 몇 번째 위치인지
        int position = n - sum;

        int up, down; // 분자, 분모

        if (line % 2 == 1) {
            // 홀수 번째 대각선: 분자는 --, 분모는 ++
            up = line - position + 1;
            down = position;
        } else {
            // 짝수 번째 대각선: 분자는 ++, 분모는 --
            up = position;
            down = line - position + 1;
        }

        System.out.println(up + "/" + down);
    }
}
