// https://www.acmicpc.net/problem/14719
// 14719: 빗물
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static int answer;
    public static int N, M;
    public static int[] heights;
    public static int leftMax;
    public static int rightMax;

    public static void main(String[] args) throws IOException {
        answer= 0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        heights= new int[M];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            heights[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<M-1; i++) {
            leftMax= 0;
            rightMax= 0;

            for (int j = 0; j <= i; j++) {
                leftMax= Math.max(leftMax, heights[j]);
            }

            for (int j = i; j < M; j++) {
                rightMax= Math.max(rightMax, heights[j]);
            }

            int waterHeight = Math.min(leftMax, rightMax);
            if (waterHeight > heights[i]) {
                answer+= waterHeight - heights[i];
            }
        }

        System.out.println(answer);
    }
}
