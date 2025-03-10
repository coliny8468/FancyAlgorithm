import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int time = 0;
        while(!q.isEmpty()){
            time++;

            int a = q.poll();
            if (time%k == 0) {
                ans.add(a);
            }else{
                q.add(a);
            }
        }
        System.out.print("<");
        for (int i = 0; i < n-1; i++) {
            System.out.print(ans.get(i)+", ");
        }

        System.out.print(ans.get(n-1));
        System.out.print(">");
    }
}
