import java.util.*;

public class Main {
	 public static void main(String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 String lcs[] = new String[3]; 
		 for (int i = 0; i < 3; i++) {
			lcs[i] = sc.next();
		 }
		 
		    int lenA = lcs[0].length();
		    int lenB = lcs[1].length();
		    int lenC = lcs[2].length();
	        
		 
		 int [][][]dp = new int[lenA+1][lenB+1][lenC+1];
		 
		 
		 
		 for (int i = 1; i <= lenA; i++) {
			 for (int j = 1; j <= lenB; j++) {
				 for (int k = 1; k <= lenC; k++) {
					if(lcs[0].charAt(i-1) == lcs[1].charAt(j-1)&&lcs[0].charAt(i-1) == lcs[2].charAt(k-1)) 
					{
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}else {
						 dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);					}
				}
			}
	
		}
		 
		System.out.println(dp[lenA][lenB][lenC]);  
	    }
	}
