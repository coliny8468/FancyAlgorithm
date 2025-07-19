import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = -1;
        int a = n / 5;
        while (a >= 0) {
            int b = (n - (5 * a)) / 3;
            if (a * 5 + b * 3 == n) {
                answer = a + b;
                break;
            } else {
                a--;
            }
        }

        System.out.println(answer);
    }
}
