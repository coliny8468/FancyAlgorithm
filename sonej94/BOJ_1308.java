import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int y1 = Integer.parseInt(st1.nextToken());
		int m1 = Integer.parseInt(st1.nextToken());
		int d1 = Integer.parseInt(st1.nextToken());
		
		int y2 = Integer.parseInt(st2.nextToken());
		int m2 = Integer.parseInt(st2.nextToken());
		int d2 = Integer.parseInt(st2.nextToken());
		
		boolean over = false;
		
		if(y2 > y1+1000){
			over = true;
		}else if(y2 == y1+1000 ) {
			
			if(m2> m1){
				over =true;
				
			}else if(m2 == m1 && d2 >= d1) {
				over = true;
			}
		}
		
		if(over){
			System.out.println("gg");
		}else {
			int diff = getDays(y2, m2, d2) - getDays(y1, m1, d1);
			System.out.println("D-" + diff);
		}
	}

	// 전체 일수
	static int getDays(int y, int m, int d) {
		int total = 0;
		
		// 연도별 일수
		for(int i=1; i<y; i++){
			total += leap(i)? 366 : 365;
		}
		
		// 월별 일수
		for(int i =1; i<m; i++){
			if(i ==2 && leap(y)) {
				total += 29;
			}else {
				total += days[i-1];
			}
		}
		
		total += d;
		
		return total;
	}
	
	// 윤년
	static boolean leap(int year) {
		return (year % 4 == 0 && year%100 != 0 || year % 400 == 0);
	}
	
}
