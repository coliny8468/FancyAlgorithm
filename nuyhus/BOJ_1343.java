import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '.') {
                if (temp % 2 != 0) {
                    System.out.println("-1");
                    return;
                } else if (temp == 2) {
                    sb.append("BB");
                }
                temp = 0;
                sb.append('.');
            } else {
                temp++;
                if (temp == 4) {
                    sb.append("AAAA");
                    temp = 0;
                }
            }
        }

        if (temp == 2) {
            sb.append("BB");
        } else if (temp != 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(sb);
    }
}
