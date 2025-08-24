class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<String>();
        go(n, 0, 0, "", answer);
        return answer;
    }

    public void go(int n, int openNum, int closeNum, String str, List<String> list) {

        if (openNum == n && closeNum == n) {
            list.add(str);
            return;
        }

        if (openNum < n) {
            go(n, openNum + 1, closeNum, str + "(", list);
        }

        if (openNum > closeNum) {
            go (n, openNum, closeNum + 1, str + ")", list);
        }
    }
}
