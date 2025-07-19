import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s =  new Stack();
        s.push(arr[0]);
        for(int i = 1 ; i< arr.length; i++){
            if(s.peek() != arr[i]){
                s.push(arr[i]);
            }
        }
        int size = s.size();
        int[] answer = new int[size];
        
        for(int i = 0; i< size; i++){
           answer[size -i-1] = s.pop();
        }
        
        return answer;
    }
}
