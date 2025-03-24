// https://www.acmicpc.net/problem/1100
// 1100: 하얀 칸
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1100 {
    public static int answer;

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for(int j = 0; j < 8; j++){
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1) ){
                    if (line.charAt(j) == 'F') answer++;
                }
            }
        }
        System.out.println(answer);
    }
}