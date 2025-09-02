class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        int zero = 0;
        int all = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                all *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero == 0) {
                answer[i] = all / nums[i];
            } else if (zero == 1) {
                if (nums[i] == 0) {
                    answer[i] = all;
                } else {
                    answer[i] = 0;
                }
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}
