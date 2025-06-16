class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long totalPrice = 0;
        
        for(int i = 1; i <= count; i++ ){
            totalPrice = totalPrice + price * i;
        }
        
        if(totalPrice - money > 0){
            answer = totalPrice -money;
        }
      
        return answer;
    }
}
