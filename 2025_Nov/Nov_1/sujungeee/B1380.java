import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scenario = 0;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            } else {
                scenario++;
            }

            ArrayList<String> girls = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                girls.add(br.readLine());
            }

            ArrayList<Integer> losts = new ArrayList<>();

            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (losts.contains(num)) {
                    losts.remove((Integer) num);
                } else {
                    losts.add(num);
                }
            }

            System.out.println(scenario + " " + girls.get(losts.get(0) - 1));
        }
    }
}