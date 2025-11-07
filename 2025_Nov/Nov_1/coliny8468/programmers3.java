import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for (int i =0; i<arr.length ; i++){
            if(arr[i]% divisor ==0 ){
                answer.add(arr[i]);
            }
        }
        
       Collections.sort(answer);
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}


