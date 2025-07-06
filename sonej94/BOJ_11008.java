import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++){
			String[] input = br.readLine().split(" ");
			String a = input[0];
			String b = input[1];
		
			int count = 0;
			int index = 0;

			
			while(index <= a.length() - b.length()){
				
				if(a.startsWith(b,index)) {
					count++;
					index += b.length();

				}else {
					count++;
					index++;
				}
			}
			
			count += a.length()-index;
						
			System.out.println(count);
		}
	}
}
