import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 
        int newWater = 0; 

        while (true) {
            int count = countBottles(n); 
            if (count <= k) break; 
            n++;
            newWater++;
        }

        System.out.println(newWater); 
    }
    
    private static int countBottles(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++; 
            n /= 2; 
        }
        return count;
    }
}
