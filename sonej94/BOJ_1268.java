import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] arr = new int[N][5];
		
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] cnt = new int[N];
		
		for(int i =0; i<N; i++){
			for(int j =0; j<N; j++) {
				
				if(i == j) continue;
				
				for(int k=0; k<5; k++){
					
					if(arr[i][k] == arr[j][k]) {
						cnt[i]++;
						break;
					}
				}

			}
		}
		
		int max = cnt[0];
		int result = 0;
		
		for(int i = 1; i<N; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				result = i;
			}
		}
		
		
		System.out.println( result + 1 );

	}
}
