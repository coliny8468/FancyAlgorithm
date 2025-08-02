import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		int result= 0;
		
		for(int t =0; t<N; t++ ) {
			String word = br.readLine();
			
			boolean[] visited = new boolean[26];
			boolean group = true;
			char prev = 0;
			
			for(int i=0; i<word.length(); i++) {
				char now = word.charAt(i);
				
				if(now != prev ){
					
					if(visited[now-'a']) {
						group = false;
						break;
					}
					visited[now -'a'] = true;
				}
				
				prev = now;
			}
			
			if(group) result++;
		}
		
		System.out.println(result);
	}
	
}
