import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [][] table = new int[][]{
            {0,2,0,1}, {2,1,3,0}, {0,3,2,1}, {1,0,1,3}
                //0 =A, 1=G, 2 = C, 3 = T
        };


        int n = sc.nextInt();
        String word = sc.next();
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == 'A') {
                num.add(0);
            } else if (word.charAt(i) == 'G') {
                num.add(1);
            }else if (word.charAt(i) == 'C') {
                num.add(2);
            }else if (word.charAt(i) == 'T') {
                num.add(3);
            }
        }

      while(num.size()> 1){
          int a = num.get(num.size()-1);
          num.remove(num.size()-1);
          int b = num.get(num.size()-1);
          num.remove(num.size()-1);
          num.add(table[a][b]);

      }

        if (num.get(0) == 0) {
            System.out.println('A');
        } else if (num.get(0)==1) {
            System.out.println('G');
        }else if (num.get(0)==2) {
            System.out.println('C');
        }else if (num.get(0)==3) {
            System.out.println('T');
        }

    }
}
