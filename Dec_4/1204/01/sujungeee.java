// https://www.acmicpc.net/problem/17297
// 17297: Messi Gimossi
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class sujungeee {
    public static int M;
    public static int[] length;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        M= Integer.parseInt(br.readLine());

        length= new int[50]; // 50까지면 피보나치 수가 Integer.MAX_VALUE 까지 커버됨
        length[0]= 5; // "Messi"
        length[1]= 13; // "Messi Gimossi"

        for(int i=2; i<50; i++) {
            length[i]= length[i-1] + 1 + length[i-2];
            if (M<= length[i]) {
                find_letter(M, i);
                break;
            }
        }
    }

    public static void find_letter(int m, int idx) {
        if (idx == 0) {
            System.out.println("Messi".charAt(m-1));
            return;
        }
        if (idx == 1){
            if (m == 6){
                System.out.println("Messi Messi Gimossi");
            } else {
                System.out.println("Messi Gimossi".charAt(m-1));

            }
            return;
        }

        if (m <= length[idx-1]) { // [n-1] [n-2] 이등분 중 [n-1]쪽에 m이 있으면
            find_letter(m, idx-1);
        } else if (m == length[idx-1] + 1) { // [n-1] [n-2] 이등분 중 가운데인 공백"" 에 m이 있으면
            System.out.println("Messi Messi Gimossi");
        } else { // [n-1] [n-2] 이등분 중 [n-2]쪽에 m이 있으면
            find_letter(m-length[idx-1]-1, idx-2);
        }
    }
}