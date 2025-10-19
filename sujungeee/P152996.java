import java.util.*;

class Solution152996 {
    Map<Double, Long> counts;

    public long solution(int[] weights) {
        long answer = 0;

        // 1
        counts = new HashMap<>();
        for (double weight : weights) {
            counts.put(weight, counts.getOrDefault(weight, 0L) + 1);
        }

        // 2
        for (Double key : counts.keySet()) {
            // 2-1
            long count = counts.get(key);
            if (count >= 2) { // 1:1
                answer += (count * (count - 1) / 2);
            }
            // 2-2
            if (counts.containsKey(key * 3 / 2)) { // 2:3
                answer += count * counts.get(key * 3 / 2);
            }
            // 2-3
            if (counts.containsKey(key * 4 / 3)) { // 3:4
                answer += count * counts.get(key * 4 / 3);
            }
            // 2-4
            if (counts.containsKey(key * 2)) { // 1:2
                answer += count * counts.get(key * 2);
            }
        }

        return answer;
    }
}

public class P152996 {
    public static void main(String[] args) {
        Solution152996 s = new Solution152996();
        System.out.println(s.solution(new int[] {100, 180, 360, 100, 270}));
    }
}