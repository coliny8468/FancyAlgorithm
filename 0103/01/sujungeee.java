// https://www.acmicpc.net/problem/2195
// 2195: 문자열 복사
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class sujungeee {
    public static int answer;
    public static String S, P;

    public static void main(String[] args) throws IOException {
        answer= 0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        S= br.readLine();
        P= br.readLine();

        int idx= 0; // P의 부분 문자열의 시작 인덱스
        int pLength= P.length();
        while (idx < pLength) {
            String tmp= "";

            if (S.indexOf(P.substring(idx)) != -1) {
                answer++;
                break;
            }

            for (int i = idx; i < pLength; i++) {
                tmp+= P.charAt(i);

                if (S.indexOf(tmp) == -1) {
                    answer++;
                    idx= i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}