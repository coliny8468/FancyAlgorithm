import java.io.*;
import java.util.*;

public class Main {
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();

        List<String> results = new ArrayList<>();
        int length = word.length();

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String p1 = word.substring(0, i);
                String p2 = word.substring(i, j);
                String p3 = word.substring(j, length);

                StringBuilder result = new StringBuilder();

                StringBuilder sb1 = new StringBuilder(p1);
                result.append(sb1.reverse());

                StringBuilder sb2 = new StringBuilder(p2);
                result.append(sb2.reverse());

                StringBuilder sb3 = new StringBuilder(p3);
                result.append(sb3.reverse());

                results.add(result.toString());
            }
        }

        Collections.sort(results);
        System.out.println(results.get(0));
    }
}