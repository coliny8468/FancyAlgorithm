import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();

        System.out.println(findNum(k));
    }

    public static String findNum(long k) {
        StringBuilder num = new StringBuilder();

        //2진수처럼 생각해서 .. 
        while (k > 0) {
            if (k % 2 == 1) {
                num.append("4");
            } else {
                num.append("7");
            }
            k = (k - 1) / 2;
        }

        return num.reverse().toString();
    }
}
