import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();

        if (target == 64) {
            System.out.println(1);
            return;
        }else{
            int cnt = 0;
            int len = 64;

            while(target != 0){
                len = len/2;
                if(len <= target){
                    target = target - len;
                    cnt++;
                }
            }

            System.out.println(cnt);

        }

    }
}
