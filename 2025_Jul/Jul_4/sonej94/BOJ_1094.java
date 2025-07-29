import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine().trim());
		
		int current = 64;
		int sum = current;
		int count = 1;
		
		while(sum > x){
			current /= 2;
			
			if(sum - current >= x) {
				
				sum -= current;
			}else {
				count++;
			}
			
		}
		
		System.out.println( count );

	}
}
