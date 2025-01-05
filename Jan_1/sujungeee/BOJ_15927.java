// https://www.acmicpc.net/problem/15927
// 15927: 회문은 회문아니야!!

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BOJ_15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String str= br.readLine();
        int length= str.length();
        boolean allSame= true; // 모든 문자가 같은지 확인하는 변수

        for(int i=0; i<length/2; i++) {
            char start= str.charAt(i);
            char end= str.charAt(length-i-1);
            if (start != end) { // 글씨가 전부 다 다른 경우
                System.out.println(length);
                return;
            }
            if (str.charAt(i) != str.charAt(i+1)) {
                allSame = false;
            }
        }

        if (allSame) { // 모든 문자가 같은 경우
            System.out.println(-1);
        } else { // 팰린드롬인 경우
            System.out.println(length - 1);
        }
    }
}