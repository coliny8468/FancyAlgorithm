import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
