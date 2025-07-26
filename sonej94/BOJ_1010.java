import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
	
		long[][] c = new long[31][31];
	
		for(int n =0; n<=30; n++) {
			c[n][0]=1;
			c[n][n] =1;
			
			for(int k=1; k<n; k++) {
				c[n][k] = c[n-1][k-1] + c[n-1][k];
			}
			
		}
		
		for (int tc = 1; tc <= T; tc++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    
		    sb.append(c[M][N]).append('\n');
		}
		
		System.out.println( sb );

	}
}
