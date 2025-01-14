import java.io.*;
import java.util.*;

public class BOJ_2195 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int cnt = 0;
        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            if (s.contains(p.substring(start, i + 1))) continue;
            cnt++;
            start = i;
        }

        System.out.println(cnt + 1);
    }
}