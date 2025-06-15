import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stick = {64, 32, 16, 8, 4, 2, 1};

        int cnt = 0;
        for (int i : stick) {
            if (n >= i) {
                cnt++;
                n -= i;
            }

            if (n == 0) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
