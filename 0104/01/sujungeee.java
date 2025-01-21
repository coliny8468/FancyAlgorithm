// https://www.acmicpc.net/problem/15681
// 15681: 트리와 쿼리
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sujungeee {
    public static int N, R, Q;

    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static int[] subTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph= new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st= new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            // 양방향
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        visited= new boolean[N+1];
        subTree= new int[N+1];

        makeTree(R);

        for(int i=0; i<Q; i++) {
            int u= Integer.parseInt(br.readLine());
            System.out.println(subTree[u]);
        }
    }

    public static void makeTree(int curNode) {
        visited[curNode]= true;
        subTree[curNode]= 1;

        for(int childNode: graph.get(curNode)) {
            if(!visited[childNode]) {
                makeTree(childNode);
                subTree[curNode]+= subTree[childNode];
            }
        }
    }
}