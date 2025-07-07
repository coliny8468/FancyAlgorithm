class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int window = p.length();
        long target = Long.parseLong(p); 

        for (int i = 0; i <= t.length() - window; i++) {  
            String sub = t.substring(i, i + window);       
            long value = Long.parseLong(sub);             
            if (value <= target) {                       
                answer++;
            }
        }

        return answer;
    }
}
