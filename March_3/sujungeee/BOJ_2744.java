// https://www.acmicpc.net/problem/2744
// 2744: 대소문자 바꾸기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2744 {
    public static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }
            else if (Character.isUpperCase(ch))
                ch = Character.toLowerCase(ch);
            sb.append(ch);
        }
        System.out.println(sb);
    }
}