import java.util.*;


public class Main {
    static int n;
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        parent = new int[n + 1];


        for (int i = 1; i < n + 1; i++) {

            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }

       int parent1 = find(1);
        for (int i = 2; i <= n ; i++) {
            if (parent1 != find(i)) {
                System.out.println(1 + " " + i);
                break;
            }
        }

    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    static int find(int a){
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

}
