import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        System.out.print(sb.toString());
    }
}