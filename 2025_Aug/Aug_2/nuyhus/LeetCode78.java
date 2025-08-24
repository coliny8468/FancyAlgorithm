class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());

        for(int i = 1; i <= nums.length; i++) {
            calc(0, i, 0, new ArrayList<Integer>(), nums, answer);
        }

        return answer;
    }

    public void calc(int cnt, int n, int start, List<Integer> list, int[] nums, List<List<Integer>> answer) {

        if (cnt == n) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            calc(cnt + 1, n, i + 1, list, nums, answer);
            list.remove(list.size() - 1);
        }
    }
}
