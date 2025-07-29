import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine().trim());
		
		int diag =0;
		int sum =0;
		
		while( sum+(diag+1) < x) {
			diag++;
			sum += diag;
		}
		diag++;
		
		int pos = x - sum;
		
		int num = 0, denom = 0;
		
		if(diag % 2 == 0){
			num = pos;
			denom = diag - pos +1;
		}else {
			num = diag - pos +1;
			denom = pos;
		}
		
		
		System.out.println( num + "/" + denom );

	}
}
