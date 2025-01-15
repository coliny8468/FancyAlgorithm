import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();  // 원본 문자열
        String p = sc.next();  // 목표 문자열

        int m = S.length();  // S의 길이
        int n = p.length();  // P의 길이

        int copyCount = 0;  // 복사 횟수
        int i = 0;  // P의 인덱스

        // P의 전체 문자열을 만들기 위해 S에서 복사
        while (i < n) {
            int maxMatchLength = 0;

            // S에서 P[i]부터 일치하는 부분을 최대한 길게 찾기
            for (int j = 0; j < m; j++) {
                int matchLength = 0;
                // S[j]부터 P[i]와 일치하는 부분을 찾기
                while (i + matchLength < n && j + matchLength < m && p.charAt(i + matchLength) == S.charAt(j + matchLength)) {
                    matchLength++;
                }
                maxMatchLength = Math.max(maxMatchLength, matchLength);
            }

            // 최대 일치 길이를 복사하고 P의 인덱스를 이동
            i += maxMatchLength;
            copyCount++;  // 복사 횟수 증가
        }

        // 결과 출력
        System.out.println(copyCount);  // 최소 복사 횟수 출력
    }
}
