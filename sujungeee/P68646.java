class Solution68646 {
    int N;
    int[] leftMins;
    int[] rightMins;

    public int solution(int[] a) {
        N = a.length;
        // 1
        leftMins = new int[N];
        rightMins = new int[N];

        leftMins[0] = a[0];
        rightMins[N - 1] = a[N - 1];

        for (int i = 1; i < N; i++) {
            leftMins[i] = Math.min(a[i], leftMins[i - 1]);
            rightMins[N - i - 1] = Math.min(a[N - i - 1], rightMins[N - i]);
        }

        // 2
        int answer = 2;

        // 3
        for (int i = 1; i < a.length - 1; i++) {
            if (!(leftMins[i - 1] < a[i] && rightMins[i + 1] < a[i])) answer++;
        }

        return answer;
    }
}

public class P68646 {
    public static void main(String[] args) {
        Solution68646 s = new Solution68646();

        System.out.println(s.solution(new int[] {9,-1,-5}));
        System.out.println(s.solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
}