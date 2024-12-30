import java.util.Scanner;

public class BOJ_15927 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String msg = sc.next();

        if(isOneChar(msg)) {
            System.out.println(-1);
        } else if (isPalindrome(msg)) {
            System.out.println(msg.length()-1);
        } else {
            System.out.println(msg.length());
        }
    }

    private static boolean isOneChar(String msg) {
        char firstChar = msg.charAt(0);
        for (int i = 1; i < msg.length(); i++) {
            if(msg.charAt(i) != firstChar) return false;
        }

        return true;
    }

    private static boolean isPalindrome(String msg) {
        int left = 0;
        int right = msg.length()-1;
        while(left<right) {
            if(msg.charAt(left) != msg.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
