import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int fileCnt = sc.nextInt();
           PriorityQueue<Long> files = new PriorityQueue<>();
           Long cost = 0L;

            for (int j = 0; j < fileCnt; j++) {
                files.add(sc.nextLong());
            }

            while (files.size()>1){
                Long nowCost = files.poll() + files.poll();
                cost = cost + nowCost;

                files.add(nowCost);
            }

            System.out.println(cost);

        }

    }

}
