import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strArr = str.split("");
        List<Integer> list = new ArrayList<>();
        for (String s : strArr) {
            list.add(Integer.parseInt(s));
        }
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}
