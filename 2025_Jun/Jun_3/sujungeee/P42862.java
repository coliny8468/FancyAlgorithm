// https://school.programmers.co.kr/learn/courses/30/lessons/42862
class Solution42862 {
    int[] arr;

    public int solution(int n, int[] lost, int[] reserve) {
        // 1
        int answer = n - lost.length;

        // 2
        arr = new int[n];
        for(int r : reserve) arr[r - 1] = 1;
        for(int l : lost) arr[l - 1] -= 1;

        // 3
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                if (i != 0 && arr[i - 1] == 1) {
                    arr[i - 1] = 0;
                    arr[i] = 0;
                } else if (i != n - 1 && arr[i + 1] == 1) {
                    arr[i + 1] = 0;
                    arr[i] = 0;
                }
            }
        }

        // 4
        int getStudentNum = lost.length;
        for(int value : arr) {
            if (value == -1) getStudentNum--;
        }

        // 5
        return answer + getStudentNum;
    }
}

public class P42862 {
    public static void main(String[] args) {
        Solution42862 s = new Solution42862();

        System.out.println(s.solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
        System.out.println(s.solution(5, new int[] {2, 4}, new int[] {3}));
        System.out.println(s.solution(3, new int[] {3}, new int[] {1}));
    }
}