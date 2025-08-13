class Solution {
    public String solution(String s) {
        String[] words = s.split(" "); //공백 기준으로 쪼개어 담기
        int[] nums = new int[words.length];
        for (int i = 0; i<words.length; i++) {
            nums[i] = Integer.parseInt(words[i]);
        }
        
        int max = nums[0];
        int min = nums[0];
        for (int i =1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        
        String answer = min + " " + max;
        return answer;
    }
}
