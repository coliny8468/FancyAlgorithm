class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int minMove = n - 1;
        for(int i=0; i<n; i++){
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A') next++;
            int move = i + n - next + Math.min(i, n - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;

        return answer;
    }
}
