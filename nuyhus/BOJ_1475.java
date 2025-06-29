import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        while (n != 0) {
            map.put(n % 10, map.getOrDefault(n % 10, 0) + 1);
            n /= 10;
        }

        int a = map.getOrDefault(6, 0);
        int b = map.getOrDefault(9, 0);
        int apb = (a + b) / 2;
        if ((a + b) % 2 > 0) {
            apb += 1;
        }
        map.put(6, apb);
        map.put(9, apb);

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        System.out.println(map.get(keySet.get(0)));
    }
}
