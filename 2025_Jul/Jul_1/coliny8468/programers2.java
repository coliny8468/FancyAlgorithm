class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int s1 = 0;
        int s2 = 0;
        
        for(int i = 0; i< goal.length; i++){
            if(cards1.length > s1 && cards1[s1].equals(goal[i])){
                s1++;
                continue;
            }else if(cards2.length > s2 &&cards2[s2].equals(goal[i])){
                s2++;
                continue;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
