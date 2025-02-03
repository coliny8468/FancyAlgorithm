import java.io.IOException;

import java.io.InputStreamReader;

import java.io.BufferedReader;

import java.util.StringTokenizer;

public class BOJ_10872 {

    public static int N, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());

        answer= 1;

    

        for(int i= 1; i<=N; i++) {

            answer *= i;

        }

        System.out.println(answer);

    }

}