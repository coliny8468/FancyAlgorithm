import java.io.*;

public class BOJ_2661 {

    static int n;
    static StringBuilder num = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num.append("1");

        backTracking(1);
        System.out.println(num);
    }

    private static boolean backTracking(int idx) {
        if (idx == n) {
            return true;
        }

        for (int j = 1; j <= 3; j++) {
            num.append(j);
            if (check(num.toString())) {
                if (backTracking(idx + 1)) {
                    return true;
                }
            }
            num.deleteCharAt(num.length() - 1);
        }
        return false;
    }

    static boolean check(String str) {
        int size = str.length();

        for (int i = 1; i <= size / 2; i++) {
            String a = str.substring(size - i);
            String b = str.substring(size - 2 * i, size - i);

            if (a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
