import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 입력 개수
        sc.nextLine();  // 개행 문자 제거

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();  // 한 줄 입력받음
            String[] parts = input.split(",");  // 쉼표 기준으로 나눔

            int num1 = Integer.parseInt(parts[0].trim());  // 첫 번째 숫자
            int num2 = Integer.parseInt(parts[1].trim());  // 두 번째 숫자
            System.out.println(num1 + num2);  // 두 숫자의 합 출력
        }
    }
}
