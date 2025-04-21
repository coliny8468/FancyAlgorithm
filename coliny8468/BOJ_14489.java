import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coin1 = sc.nextInt();
        int coin2 = sc.nextInt();
        int chicken = sc.nextInt();

        if(coin1+coin2>=chicken*2){
            System.out.println(coin1+coin2 - chicken*2);
        }else {
            System.out.println(coin1+coin2);

        }
    }
}
