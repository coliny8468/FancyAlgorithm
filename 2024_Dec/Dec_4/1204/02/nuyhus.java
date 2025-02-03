import java.util.*;
import java.io.*;

public class nuyhus {

    static int n, k;
    static String[] words;
    static boolean[] alphaArr = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        alphaArr['a' - 'a'] = true;
        alphaArr['n' - 'a'] = true;
        alphaArr['t' - 'a'] = true;
        alphaArr['i' - 'a'] = true;
        alphaArr['c' - 'a'] = true;

        if (k < 5) {
            System.out.println(0);
            return;
        }

        go(0, 0);
        System.out.println(max);
    }

    public static void go(int idx, int cnt) {

        if (cnt + 5 == k) {
            max = Math.max(max, countWord());
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (alphaArr[i]) {
                continue;
            }

            alphaArr[i] = true;
            go(i + 1, cnt + 1);
            alphaArr[i] = false;
        }
    }

    public static int countWord() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] word = words[i].toCharArray();
            boolean flag = true;
            for (char c : word) {
                if (!alphaArr[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}