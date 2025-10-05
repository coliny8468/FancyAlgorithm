import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int []x = new int[4];
            int []y = new int[4];
            boolean t = true;
            for (int j = 0; j < 4; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
            }

            int len[] = new int[6];
            int cnt = 0;

            for (int a = 0; a < 4; a++) {
                for (int b = a + 1; b < 4; b++) {
                    int dx = x[a] - x[b];
                    int dy = y[a] - y[b];
                    len[cnt] = dx * dx + dy * dy;
                    cnt++;

                }
            }
            
            Arrays.sort(len);

            if (len[0] == len[3] && len[4] == len[5] && len[4] > len[0]) {
                System.out.println(1);
            }else {
                System.out.println(0);
            }



        }
    }
}
