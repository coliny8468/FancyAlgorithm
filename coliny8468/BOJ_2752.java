import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            num.add(sc.nextInt());
        }

        num.sort(Comparator.naturalOrder());

        for (int i = 0; i < 3; i++) {
            System.out.print(num.get(i)+" ");
        }

    }
}
