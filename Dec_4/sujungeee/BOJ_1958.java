// https://www.acmicpc.net/problem/1958
// 1958: LCS 3
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ_1958 {
    public static String str1;
    public static String str2;
    public static String str3;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        str1= br.readLine();
        str2= br.readLine();
        str3= br.readLine();

        System.out.println(LCS(str1, str2, str3));
    }

    public static int LCS(String s1, String s2, String s3) {
        int n= s1.length();
        int m= s2.length();
        int l= s3.length();

        dp= new int[n+1][m+1][l+1];

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                for (int k=1; k<l+1; k++) {
                    if (s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) == s3.charAt(k-1)) {
                        dp[i][j][k]= dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k]= Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[n][m][l];
    }
}