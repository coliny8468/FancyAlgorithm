// https://www.acmicpc.net/problem/24883
// 24883: 자동완성
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        if (c == 'N') {
            System.out.println("Naver D2");
        } else if (c == 'n'){
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }
    }
}