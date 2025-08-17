class Solution {
    public int solution(int a, int b, int n) {
        int coke = 0;
        
        while (n >= a) {  
            int exchanged = (n / a) * b; 
            coke += exchanged;
            n = exchanged + (n % a); 
        }
        
        return coke;
    }
}
