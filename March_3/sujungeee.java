// https://www.acmicpc.net/problem/1148
// 1148: 단어 만들기
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sujungeee {
    public static List<HashMap<Character, Integer>> freqList;
    public static class Info {
        int count;
        List<Character> charList;

        Info (int count, List<Character> charList) {
            this.count = count;
            this.charList = charList;
        }
    }

    public static void main(String[] args) throws IOException {
        freqList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어마다 문자:빈도수 저장
        // freqList: [{A=1, P=2, L=1, E=1}, {B=1, A=3, N=2}, ...]
        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("-")) break;
            HashMap<Character, Integer> freq = new HashMap<>();
            for (char c : tmp.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            freqList.add(freq);
        }

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;
            solution(input);
        }
    }

    public static void solution(String input) {
        Info minInfo = new Info(200_000, new ArrayList<>()); // 가장 적은 단어 정보
        Info maxInfo = new Info(0, new ArrayList<>()); // 가장 많은 단어 정보

        // freq:{L=2, A=1, R=1, B=1, I=2, T=1, N=1}
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Character centerChar: freq.keySet()) { // centerChar: 정중앙에 있는 char
            // count: centerChar를 정중앙에 놓았을 때, 만들 수 있는 단어 개수
            int count = 0;

            for (HashMap<Character, Integer> compFreq : freqList) {
                if (!compFreq.containsKey(centerChar) || freq.get(centerChar) < compFreq.get(centerChar)) continue;

                // 단어별 빈도수
                boolean flag = true;
                for (Character key: compFreq.keySet()) {
                    if (!freq.containsKey(key) || freq.get(key) < compFreq.get(key)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    count++;
                }
            }

            // min, max 갱신
            if (count < minInfo.count) {
                minInfo.count = count;
                minInfo.charList.clear();
                minInfo.charList.add(centerChar);
            } else if (count == minInfo.count){
                minInfo.charList.add(centerChar);
            }

            if (count > maxInfo.count) {
                maxInfo.count = count;
                maxInfo.charList.clear();
                maxInfo.charList.add(centerChar);
            } else if (count == maxInfo.count) {
                maxInfo.charList.add(centerChar);
            }
        }

        // 답 추출
        StringBuilder sb = new StringBuilder();
        Collections.sort(minInfo.charList);
        for (Character c : minInfo.charList) {
            sb.append(c);
        }
        sb.append(" ").append(minInfo.count).append(" ");
        Collections.sort(maxInfo.charList);
        for (Character c : maxInfo.charList) {
            sb.append(c);
        }
        sb.append(" ").append(maxInfo.count);
        System.out.println(sb);
    }
}