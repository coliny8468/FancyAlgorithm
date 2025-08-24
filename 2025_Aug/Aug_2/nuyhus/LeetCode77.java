class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        go(answer, new ArrayList<>(), 0, 1, n, k);
        return answer;
    }

    public void go(List<List<Integer>> answer, List<Integer> list, int count, int start, int n, int k) {
        if (count == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            go(answer, list, count + 1, i+1, n, k);
            list.removeLast();
        }
    }
}
