import java.io.*;
import java.util.Arrays;

public class nuyhus {

    static String[] dictionary;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCnt = Integer.parseInt(br.readLine());
        dictionary = new String[wordCnt];
        for (int i = 0; i < wordCnt; i++) {
            dictionary[i] = br.readLine();
        }

        int sentenceCnt = Integer.parseInt(br.readLine());
        String[] sentences = new String[sentenceCnt];
        for (int i = 0; i < sentenceCnt; i++) {
            sentences[i] = br.readLine();
        }

        for (String stc : sentences) {
            String[] words = stc.split(" ");

            int tmp = 1;
            for (String word : words) {
                tmp *= countWord(word);
            }

            System.out.println(tmp);
        }
    }

    private static int countWord(String word) {
        int cnt = 0;
        int wordLength = word.length();
        for (String wordInD : dictionary) {
            if (wordLength != wordInD.length()) continue;
            char[] wordArray = word.toCharArray();
            char[] wordInDArray = wordInD.toCharArray();
            if (wordArray[0] == wordInDArray[0] && wordArray[wordLength - 1] == wordInDArray[wordLength - 1]) {
                Arrays.sort(wordArray);
                Arrays.sort(wordInDArray);
                boolean same = true;
                for (int i = 0; i < wordLength; i++) {
                    if (wordArray[i] != wordInDArray[i]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
