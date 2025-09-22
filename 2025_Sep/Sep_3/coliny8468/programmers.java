import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        Set<Integer> mod = new HashSet<>();
        int a = 1;
        int cnt = 1;
        
        while(a<=1000){
            mod.add(a);
            cnt++;
            a = cnt*cnt;
        }
        
        for(int i = left; i<=right; i++){
            if(mod.contains(i)){
                answer -= i;
            }else{
                answer += i;
            }
        }
            
        return answer;
    }
}
