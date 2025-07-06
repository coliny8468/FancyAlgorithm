import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static final int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
		String a = br.readLine().trim();
		String b = br.readLine().trim();

		int n = a.length();
		int[] arr = new int[2*n];
		
		for(int i =0; i<n; i++) {
			arr[2*i] = alpha[a.charAt(i)-'A'];
			arr[2*i+1] = alpha[b.charAt(i)-'A'];
		}
		
		while(arr.length>2) {
			int[] next = new int[arr.length -1];
			for(int i = 0; i<next.length; i++) {
				next[i] = (arr[i]+ arr[i+1]) % 10;
			}
			arr=next;
		}
		
		System.out.println(arr[0] + "" + arr[1]);
	}
}
