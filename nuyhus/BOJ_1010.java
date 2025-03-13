import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BOJ_1010 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[30][30];
 
		// 2번 성질 (n == r, r == 0)
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
			
 
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				// 1번 성질 
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N이다.
			int N = Integer.parseInt(st.nextToken());	// N = r
			int M = Integer.parseInt(st.nextToken());	// M = n
					
			sb.append(dp[M][N]).append('\n');
		}
		
		System.out.println(sb);
 
	}
}
