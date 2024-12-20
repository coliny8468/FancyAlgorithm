import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_6497 {

    static int[] parent; //각 집을 연결 상태로 관리하기 위한 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            if (m==0 && n==0) break;

            List<int[]> list = new ArrayList<>(); //길 정보 저장 
            int totalCost = 0; //모든 길 초기비용 합

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                list.add(new int[]{x, y, z});
                totalCost +=z; //전체비용 증가시킴
            }

            //비용 기준으로 길을 오름차순 정렬
            //가장 싼 길부터!!
            list.sort(Comparator.comparingInt(o -> o[2]));

            //각 집이 자기 자신을 부모로 설정함 (초기화)
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            
            int mstCost = 0; //최소비용신장트리(mst) 총비용
            for (int[] edge : list) {

                if (find(edge[0]) != find(edge[1])) { // 두 집 서로 연결x라면
                    union(edge[0], edge[1]);//연결
                    mstCost += edge[2]; //mst 증가
                }
            }

            System.out.println(totalCost - mstCost); //절약가능비용 계산
        }
    }

    static int find(int x) { //부모노드 찾기
        if(parent[x] == x) return x; //자기자신이 부모면 반환
        return parent[x] = find(parent[x]); //부모 찾아서 업데이트
    }

    static void union(int x, int y) { //두 집합을 하나로 합치기
        x = find(x); //x의 루트 노드 찾기
        y = find(y); //y의~~

        if (x!=y) { //루트 다르면 합치기 
            parent[x] = y;
        }
    }
}
