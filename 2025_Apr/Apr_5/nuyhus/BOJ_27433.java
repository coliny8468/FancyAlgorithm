import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27433 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
        }

        System.out.println(temp);
    }
}
