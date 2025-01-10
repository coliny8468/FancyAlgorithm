import java.util.*;


public class Main {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       
       Set<Integer> card = new HashSet<>();
       
        for (int i = 0; i < n; i++) {
            card.add(sc.nextInt());
        }
        
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int newCard = sc.nextInt();
            int size = card.size();
            card.add(newCard);
            if (size == card.size()) {
                System.out.println(1);
            }else {
                System.out.println(0);
                card.remove(newCard);
            }
        }
       
    }
}
