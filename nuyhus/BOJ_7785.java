import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        List<String> key = new ArrayList<>(map.keySet());
        Collections.sort(key);
        Collections.reverse(key);

        StringBuilder sb = new StringBuilder();
        for (String k : key) {
            if (map.get(k).equals("enter")) {
                sb.append(k).append("\n");
            }
        }

        System.out.println(sb);
    }
}
