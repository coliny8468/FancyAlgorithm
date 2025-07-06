import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		
		List<String> names = new ArrayList<>();
		for(int i=0; i<n; i++) {
			names.add(br.readLine());
		}
	
		boolean isIncreas = true;
		boolean isDecreas = true;
		
		for (int i= 1; i<n; i++) {
			if(names.get(i).compareTo(names.get(i-1))<0) {
				isIncreas =false;
			}
			
			if(names.get(i).compareTo(names.get(i-1))>0) {
				isDecreas = false;
			}
		}
		
		if(isIncreas) {
			System.out.println("INCREASING");
		}else if(isDecreas) {
			System.out.println("DECREASING");
		}else {
			System.out.println("NEITHER");
		}
		
	}
}
