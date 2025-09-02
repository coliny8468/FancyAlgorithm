import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() > 1){
            cnt++;
            pq.add(pq.poll() + pq.poll()*2);
        }

        if(pq.size() == 1 && pq.peek() < K){
            cnt = -1;
        }
        return cnt;
    }
}
