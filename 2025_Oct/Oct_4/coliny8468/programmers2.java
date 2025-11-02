import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] list = new int[k];
        int min = 2001;
        
       for (int i = 0; i < Math.min(k, score.length); i++) {
            list[i] = score[i];
            answer[i] = Math.min(min, score[i]); 
            min = Math.min(min, score[i]); 
        }
        
        Arrays.sort(list); 

        for(int i = k; i<score.length; i++){
           if(score[i] > list[0]){
               list[0] = score[i];
                Arrays.sort(list); 
               answer[i] = list[0];
           } else{
               answer[i] = list[0];
           }
              
        }
        
        return answer;
    }
}
