// https://www.acmicpc.net/problem/1501
// 1501: 영어 읽기

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class sujungeee {
    static int answer;
    static int N;
    static int M;
    static Map<String, Integer> dictionarys;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        dictionarys= new HashMap<>();
        for(int i=0; i<N; i++) {
            char[] word = br.readLine().toCharArray();
            String key= make_keys(word);
            dictionarys.put(key, dictionarys.getOrDefault(key, 0) + 1);
        }

        M= Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            String[] words = br.readLine().split(" ");
            answer= calculate(words);
            System.out.println(answer);
        }
    }

    public static int calculate(String[] words) {
        int result= 1;
        for (String tmp : words) {
            char[] word = tmp.toCharArray();
            String key= make_keys(word);
            if (dictionarys.containsKey(key)) {
                result*= dictionarys.get(key);
            } else {
                return 0;
            }
        }

        return result;
    }

    public static String make_keys(char[] word) {
        String key= "";
        if (word.length < 2) {
            key= word[0] + "";
        } else {
            if (word.length > 2) {
                char[] middleChars = Arrays.copyOfRange(word, 1, word.length - 1);
                Arrays.sort(middleChars);
                String middle = new String(middleChars);
                key= word[0] + middle + word[word.length - 1];
            } else { //
                key= "" + word[0] + word[word.length - 1];
            }
        }
        return key;
    }
}
