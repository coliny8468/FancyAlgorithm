import java.util.*;

public class Main {

    static int n, m, cnt;
    static int[][] map;
    static boolean [][] v;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        cnt = 0;
        map = new int[n][m];
        v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    findMount(i, j);
                }

            }

        }

        System.out.println(cnt);

    }

    static void findMount(int x, int y){
        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();

        qx.add(x);
        qy.add(y);
        boolean isPeek = true;
        int h =  map[x][y];

        while(!qx.isEmpty()){
            int nowx = qx.poll();
            int nowy = qy.poll();
            v[nowx][nowy] = true;

            for (int i = 0; i < dir.length; i++) {
                int newX = nowx + dir[i][0];
                int newY = nowy + dir[i][1];

                if ( newY>=0 && newX>=0 && newX< n && newY<m ) {

                    if (h == map[newX][newY] && !v[newX][newY]) {
                        qx.add(newX);
                        qy.add(newY);
                        v[newX][newY] = true;
                    }else if (h < map[newX][newY]){
                        isPeek = false;
                    }

                }

            }

        }

        if(isPeek){
            cnt++;
        }

    }
}
