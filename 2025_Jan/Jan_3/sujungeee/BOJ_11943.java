// https://www.acmicpc.net/problem/11943
// 11943: 파일 옮기기
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class BOJ_11943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n1= Integer.parseInt(st.nextToken());
        int n2= Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int n3= Integer.parseInt(st.nextToken());
        int n4= Integer.parseInt(st.nextToken());

        int x= n1 + n4;
        int y= n2 + n3;

        if (x < y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }
}
