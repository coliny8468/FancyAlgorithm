import java.util.Arrays;

class Solution87390 {
    int[] answer;

    public int[] solution(int n, long left, long right) {
        int iLeft = (int) left;
        int iRight = (int) right;
        answer = new int[iRight - iLeft + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            // 1
            long row = i / n;
            long column = i % n;
            // 2
            answer[idx++] = (int) Math.max(row, column) + 1;
        }

        return answer;
    }
}

public class P87390 {
    public static void main(String[] args) {
        Solution87390 s = new Solution87390();

        System.out.println(Arrays.toString(s.solution(3, 2, 5)));
        System.out.println(Arrays.toString(s.solution(4, 7, 14)));
    }
}