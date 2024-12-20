import java.util.*;

public class Main {

    static Map<String, Integer> dic = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사전 단어 수
        sc.nextLine(); // 개행 문자 처리

        // 사전 입력
        for (int i = 0; i < n; i++) {
            addDic(sc.nextLine());
        }

        int n2 = sc.nextInt(); // 문장 수
        sc.nextLine(); // 개행 문자 처리

        // 문장 입력 및 해석
        for (int i = 0; i < n2; i++) {
            System.out.println(countWord(sc.nextLine()));
        }
    }

    static void addDic(String word) {
        String key = makeDicWord(word);

        // 키가 이미 존재하면 값 증가, 없으면 1로 초기화
        dic.put(key, dic.getOrDefault(key, 0) + 1);
    }

    static String makeDicWord(String word) {
        if (word.length() <= 3) {
            return word; // 길이가 3 이하인 경우 그대로 반환
        }

        StringBuilder result = new StringBuilder();
        int[] al = new int[52]; // 대소문자 알파벳 카운트 배열

        // 첫 문자와 마지막 문자 추가
        result.append(word.charAt(0));
        result.append(word.charAt(word.length() - 1));

        // 중간 문자 카운트
        for (int i = 1; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                al[c - 'A']++; // 대문자
            } else if (Character.isLowerCase(c)) {
                al[c - 'a' + 26]++; // 소문자
            }
        }

        // 알파벳 카운트를 기반으로 문자열 생성
        for (int j = 0; j < 52; j++) {
            if (al[j] != 0) {
                char newC = (j < 26) ? (char) (j + 'A') : (char) (j - 26 + 'a');
                result.append(newC).append(al[j]);
            }
        }

        return result.toString();
    }

    static int countWord(String sentence) {
        String[] words = sentence.split(" "); // 공백 기준으로 단어 분리
        int cnt = 1;

        for (String word : words) {
            String key = makeDicWord(word);

            // 사전에 없는 단어가 있으면 0 반환
            if (!dic.containsKey(key)) {
                return 0;
            }

            // 단어의 해석 경우의 수 곱하기
            cnt *= dic.get(key);
        }

        return cnt;
    }
}
