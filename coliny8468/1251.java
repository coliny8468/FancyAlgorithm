import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        List<String> ans = new ArrayList<>();
        int n = a.length();

        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                String part1 = a.substring(0, i);
                String part2 = a.substring(i, j);
                String part3 = a.substring(j);

                String rev1 = new StringBuilder(part1).reverse().toString();
                String rev2 = new StringBuilder(part2).reverse().toString();
                String rev3 = new StringBuilder(part3).reverse().toString();

                ans.add(rev1 + rev2 + rev3);
            }
        }

        if (!ans.isEmpty()) {
            ans.sort(Comparator.naturalOrder());
            System.out.println(ans.get(0));
        }
    }
}
