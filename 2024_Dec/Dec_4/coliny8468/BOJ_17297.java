import java.util.*;

public class Main {
    static Long[] messiSize = new Long[100]; // 배열 크기 충분히 설정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // M번째 문자

        messiSize[1] = 5L;  // messi(1) -> "Messi"
        messiSize[2] = 13L; // messi(2) -> "Messi Gimossi"

        int index = 3;
        // 피보나치 수열로 messi의 길이 계산
        while (true) {
            messiSize[index] = messiSize[index - 1] + messiSize[index - 2] + 1;
            if (messiSize[index] > n) {
                break;
            }
            index++;
        }

        findCharacter(index, n); // 재귀로 M번째 문자 찾기
    }

    static void findCharacter(int index, long n) {
        if (index == 1) {  // messi(1) -> "Messi"
            System.out.println("Messi".charAt((int)n - 1));
            return;
        } else if (index == 2) {  // messi(2) -> "Messi Gimossi"
            char a = "Messi Gimossi".charAt((int)n-1);
            if (a == ' ') {
                System.out.println("Messi Messi Gimossi");
                return;
            } else {
                System.out.println(a);
                return;
            }
        }

        // messi(N-1)에 속하는 경우
        if (messiSize[index - 1] >= n) {
            findCharacter(index - 1, n);
        } 
        // 공백에 해당하는 경우
        else if (messiSize[index - 1] + 1 == n) {
            System.out.println("Messi Messi Gimossi");
            return;
        }
        // messi(N-2)에 속하는 경우
        else {
            findCharacter(index - 2, n - messiSize[index - 1] - 1);
        }
    }
}
