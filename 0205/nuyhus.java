import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        HashMap<Character, Integer> scores = new HashMap<>();

        for (String word : words) {
            int maxLength = word.length();
            for (char w : word.toCharArray()) {
                int score = (int) Math.pow(10, maxLength - 1);
                int total = scores.getOrDefault(w, 0) + score;
                scores.put(w, total);
                maxLength--;
            }
        }

        List<Character> keySet = new ArrayList<>(scores.keySet());
        keySet.sort((o1, o2) -> scores.get(o2).compareTo(scores.get(o1)));

        HashMap<Character, Integer> map = new HashMap<>();
        int num = 9;
        for (char key : keySet) {
            map.put(key, num);
            num--;
        }

        int sum = 0;
        for (String word : words) {
            int index = word.length() - 1;
            int wNum = 0;
            for (int i = 0; i < word.length(); i++) {
                wNum += map.get(word.charAt(i)) * (int) Math.pow(10, index);
                index--;
            }
            sum += wNum;
        }

        System.out.println(sum);
    }
}
