// https://www.acmicpc.net/problem/2661
// 2661: 좋은수열
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class BOJ_2661 {
    public static int N;
    public static List<Character> strList;
    public static final char[] array = {'1', '2', '3'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strList = new ArrayList<>();

        if (N < 2) {
            System.out.println(1);
        } else {
            dfs();
        }
    }

    public static void dfs() {
        if (strList.size() == N) {
            StringBuilder sb = new StringBuilder();
            for(Character c: strList) {
                sb.append(c);
            }
            System.out.println(sb);
            exit(0);
        }

        for(int i = 0; i < 3; i++) {
            strList.add(array[i]);
            if (!is_part_seq()) {
                dfs();
            }
            strList.remove(strList.size() - 1);
        }
    }

    public static boolean is_part_seq() {
        int len = strList.size();
        int pair = 2;
        while (pair <= len) {
            for (int i = 0; i <= len - pair; i++) {
                boolean flag = true;
                for (int j = 0; j < pair / 2; j++) {
                    if (strList.get(i + j) != strList.get(pair/2 + i + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            pair += 2;
        }
        return false;
    }
}