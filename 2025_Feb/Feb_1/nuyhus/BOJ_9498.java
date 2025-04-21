import java.util.*;
import java.io.*;

public class BOJ_9498 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (90 <= n && n <= 100) {
            System.out.println("A");
        } else if (80 <= n && n <= 89) {
            System.out.println("B");
        } else if (70 <= n && n <= 79) {
            System.out.println("C");
        } else if (60 <= n && n <= 69) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
