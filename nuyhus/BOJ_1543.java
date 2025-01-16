import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String w = br.readLine();

        int cnt = 0;
        while (str.contains(w)) {
            str = str.replaceFirst(w, "_");
            cnt++;
        }

        System.out.println(cnt);
    }
}