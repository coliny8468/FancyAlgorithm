import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution68645 {
    List<int[]> layers;
    int length;

    public int[] solution(int n) {
        layers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            layers.add(new int[i + 1]);
        }
        length = (n * (n + 1)) / 2;

        // 1
        int value = 1;
        int startIdx = 0;
        int lastIdx = n - 1;
        while(value <= length) {
            // 1-1
            for (int i = startIdx * 2; i <= lastIdx; i++) {
                layers.get(i)[startIdx] = value++;
                if (value > length) break;
            }

            // 1-2
            for (int i = startIdx + 1; i < lastIdx - startIdx; i++){
                layers.get(lastIdx)[i] = value++;
                if (value > length) break;
            }

            // 1-3
            for (int i = lastIdx; i > startIdx * 2; i--) {
                layers.get(i)[i - startIdx] = value++;
                if (value > length) break;
            }

            startIdx++;
            lastIdx--;
        }

        // 2
        int[] answer = new int[length];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int[] layer = layers.get(i);
            for (int v : layer) {
                answer[idx++] = v;
            }
        }

        return answer;
    }
}

public class P68645 {
    public static void main(String[] args) {
        Solution68645 s = new Solution68645();

        System.out.println(Arrays.toString(s.solution(4)));
        System.out.println(Arrays.toString(s.solution(5)));
        System.out.println(Arrays.toString(s.solution(6)));
        System.out.println(Arrays.toString(s.solution(7)));
    }
}