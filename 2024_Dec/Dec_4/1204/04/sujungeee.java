// https://www.acmicpc.net/problem/11509
// 11509: 풍선 맞추기
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class sujungeee {
    public static int N;
    public static int[] heights;
    public static int answer;

    public static void main(String[] args) throws IOException {
        answer= 0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        heights= new int[1_000_001];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int H= Integer.parseInt(st.nextToken());
            if (heights[H] > 0) {
                heights[H]--;
            } else {
                answer++;
            }

            heights[H-1]++;
        }

        System.out.println(answer);
    }
}