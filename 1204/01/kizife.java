import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(13);

        while (list.get(list.size() - 1) < n) {
            int next = list.get(list.size() - 1) + list.get(list.size() - 2) + 1;
            list.add(next);
        }

        System.out.println(findM(list.size() - 1, n, list));
    }

    private static String findM(int k, int n, ArrayList<Integer> list) {
        if (k < 2) {
            if (n == 6) {
                return "Messi Messi Gimossi";
            } else {
                return "Messi Gimossi".substring(n - 1, n);
            }
        }

        if (list.get(k - 1) + 1 == n) {
            return "Messi Messi Gimossi";
        }
        else if (list.get(k - 1) >= n) {
            return findM(k - 1, n, list);
        }
        else {
            return findM(k - 2, n - 1 - list.get(k - 1), list);
        }
    }
}
