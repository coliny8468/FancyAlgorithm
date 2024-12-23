import java.io.*;
import java.util.*;

public class BOJ_17297 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m = Integer.parseInt(br.readLine());

        long[] lengths = new long[100];
        lengths[1] = 5;
        lengths[2] = 13;
        int i = 2;
        while (lengths[i] < m) {
            i++;
            // messi[i] = messi[i - 1] + ' ' + messi[i - 2]
            lengths[i] = lengths[i - 1] + 1 + lengths[i - 2];
        }

        while (i > 2) {
            // messi[i - 2]에 속한 경우
            if (m > lengths[i - 1] + 1) {
                m -= (lengths[i - 1] + 1);
                i -= 2;
            } else if (m == lengths[i - 1] + 1) { // 공백인 경우
                System.out.println("Messi Messi Gimossi");
                return;
            } else { // messi[i - 1]에 속한 경우
                i -= 1;
            }
        }

        char[] charArray = "Messi Gimossi".toCharArray();
        char ans = charArray[(int) m - 1];
        if (ans == ' ') {
            System.out.println("Messi Messi Gimossi");
        } else {
            System.out.println(ans);
        }
    }
}