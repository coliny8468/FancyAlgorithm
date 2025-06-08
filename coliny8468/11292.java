import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num != 0) {

            float max = 0;
            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String name = sc.next();
                float h = sc.nextFloat();

                if (max < h) {
                    max = h;
                    ans.clear();
                    ans.add(name);
                } else if (max == h) {
                    ans.add(name);
                }
            }

            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();

            num = sc.nextInt();
        }


    }
}
