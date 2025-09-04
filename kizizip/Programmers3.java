import java.util.*;

public class Solution {
    public int solution(int n) {
        String input = String.valueOf(n);
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            answer += num;
        }

        return answer;
    }
}
