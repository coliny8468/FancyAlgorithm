
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.next();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <s.length()- i ; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = i; k <= i + j; k++) {
                    sb.append(s.charAt(k));
                }
                set.add(sb.toString());
            }
        }


        System.out.println(set.size());

    }
}
